package com.huang.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeValidationException;
import org.elasticsearch.plugin.analysis.ik.AnalysisIkPlugin;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.Netty3Plugin;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by admin on 2017/12/26.
 */
@Service
public class ESNodeService {

    private static final Logger logger = LoggerFactory.getLogger(ESNodeService.class);
    public Node node;
//    private final String elasticStorePath = "D:\\es-node";
    private final String elasticStorePath = "/Users/h/es-node";
    private AtomicLong queueSize = new AtomicLong(0l);
    private ConcurrentLinkedQueue<JSONObject> queue = new ConcurrentLinkedQueue<JSONObject>();
    private long maxQueueSize = 1024 * 1024l;
    private int maxBatchSize = 500;
    private static int storeThreadSize = 4;
    private ExecutorService executorService = null;
    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        }
    };
    private boolean parseJson = true;
    private String jsonPropertyName = "data";

    @PostConstruct
    public void startNode() throws NodeValidationException, IOException, ExecutionException, InterruptedException {
        logger.info("start es node");

        // setup
        setup();

        Settings settings = Settings.builder()
                .put("cluster.name", "my-es")
                .put("node.name", "node-1")
                .put("path.home", elasticStorePath)
                .put("transport.type", "local")
                .put("http.enabled", true)
                .put("http.port", 9200)
                .put("http.cors.enabled", true)
                .put("http.cors.allow-origin", "*")
                .put("http.type", "netty3")
                .put("transport.tcp.port", 9300)
                .put("network.bind_host", "0.0.0.0").build();
        Collection plugins = Arrays.asList(Netty3Plugin.class, AnalysisIkPlugin.class);
        node = new PluginConfigurableNode(settings, plugins);
        node.start();

//        setTemplateWithMapping();
    }

    public void setup() throws IOException {
        logger.info("setup analysis-ik");
        File configPath = new File(elasticStorePath, "config");
        String sourcePath = this.getClass().getClassLoader().getResource(AnalysisIkPlugin.PLUGIN_NAME).getPath();
        FileUtils.copyDirectoryToDirectory(new File(sourcePath), configPath);
    }

    public void store(JSONObject[] logs) {
        for (JSONObject log : logs) {
            store(log);
        }
    }

    public void store(JSONObject log) {
        if (queueSize.getAndIncrement() > maxQueueSize) {
            return;
        }
        queue.add(log);
    }
    
    @Scheduled(fixedDelay = 10)
    public void batchStoreLog() {
        final List<JSONObject> logs = new ArrayList<JSONObject>();
        int i = 0;
        JSONObject log = null;
        while ((log = queue.poll()) != null && i++ < maxBatchSize) {
            logs.add(log);
            queueSize.decrementAndGet();
        }
        if (i > 0) {
            ExeSer.INSTANCE.getInstance().submit(new Runnable() {
                @Override
                public void run() {
                    BulkRequestBuilder builder = node.client().prepareBulk();
                    for (JSONObject log : logs) {
                        IndexRequestBuilder index = composeIndex(log);
                        builder.add(index);
                    }
                }
            });
        }
    }
    
    public IndexRequestBuilder composeIndex(JSONObject log) {
        JSONObject source = new JSONObject();
        source.putAll(log);
        String app = source.getString("app");
        source.remove("app");
        //时间戳
        String ts = DATE_FORMAT.get().format(source.getLong("d"));
        source.put("@timestamp", ts);
        source.remove("d");

        //日志消息
        String msg = source.getString("m");
        source.put("message", msg);
        source.remove("m");

        //构建其他属性
        eval(source, "host", "host");
        eval(source, "pid", "pid");
        eval(source, "severity", "level");
        eval(source, "thread", "thread");
        eval(source, "stacktrace", "exception");
        eval(source, "logger", "logger");
        eval(source, "cn", "contextName");
        eval(source, "C", "class");
        eval(source, "M", "method");
        eval(source, "F", "file");

        //解析json字段
        if (parseJson && StringUtils.startsWith(msg, "{")) {
            try {
                JSONObject json = JSON.parseObject(msg);
                source.put(jsonPropertyName, json);
                source.remove("message");
            } catch (Exception e) {
                //pass
            }
        }

        //返回索引
        String indexName = String.format("%s-%s", app, ts.substring(0, 10));
        return node.client().prepareIndex(indexName, "log").setSource(source);
    }

    private void eval(Map<String, Object> map, String key, String propertyName) {
        if (map.get(key) == null) {
            map.remove(key);
        } else {
            map.put(propertyName, map.remove(key));
        }
    }

    /*public ExecutorService getExecutorService() {
        if (executorService == null) {
            synchronized (this) {
                if (executorService == null) {
                    executorService = Executors.newFixedThreadPool(storeThreadSize);
                }
            }
        }
        return executorService;
    }*/

    enum ExeSer {
        INSTANCE;
        private ExecutorService executorService;
        private ExeSer() {
            executorService = Executors.newFixedThreadPool(storeThreadSize);
        }
        public ExecutorService getInstance() {
            return executorService;
        }
    }


    public void setTemplateWithMapping() throws IOException, ExecutionException, InterruptedException {
        PathMatchingResourcePatternResolver pathMatchingResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResolver.getResources("classpath*:cdr/*");
        for (Resource resource:resources) {
            File file = resource.getFile();
            String indexName = file.getParentFile().getName();
            String typeName = StringUtils.substringBeforeLast(file.getName(),".");
            String content = FileUtils.readFileToString(file, Charset.forName("utf-8"));
            JSONObject json = JSONObject.parseObject(content);
            String templateName = String.format("template-%s-%s", indexName, typeName);
            PutIndexTemplateResponse response = node.client().admin().indices()
                    .preparePutTemplate(templateName)
                    .setTemplate(indexName + "*")
                    .addMapping(typeName, json).execute().get();
            logger.info(String.format("template response: %s", response.toString()));
            logger.info(String.format("add template: %s", templateName));
        }
    }

    @Test
    public void testRestSearch() throws IOException {
        // normal rest-client
        RestClient restClient = RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
                .setMaxRetryTimeoutMillis(3000).build();
        Response response = restClient.performRequest(HttpMethod.GET.name(), "/_search");
        logger.info(IOUtils.toString(response.getEntity().getContent(), Charset.forName("utf-8")));

        // high level rest-client
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200, "http")).build());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.aggregation(AggregationBuilders.terms("top_10_states").field("state").size(10));

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("social-*");
        searchRequest.types();
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest);


    }

    @Test
    public void testTransportClientSearch() {

    }
}
