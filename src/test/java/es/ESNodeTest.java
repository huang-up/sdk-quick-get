package es;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.elasticsearch.action.admin.indices.template.put.PutIndexTemplateResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeValidationException;
import org.elasticsearch.plugin.analysis.ik.AnalysisIkPlugin;
import org.elasticsearch.transport.Netty3Plugin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
 * Created by admin on 2017/12/26.
 */
public class ESNodeTest {

    private static final Logger logger = Logger.getLogger(ESNodeTest.class);
    private Node node;
    private final String elasticStorePath = "D:\\es-node";

    @Before
    public void startNode() throws NodeValidationException, IOException {
        logger.info("start es node");

        // setup
        testSetup();

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
    }

    @Test
    public void testSetup() throws IOException {
        logger.info("setup analysis-ik");
        File configPath = new File(elasticStorePath, "config");
        String sourcePath = this.getClass().getClassLoader().getResource(AnalysisIkPlugin.PLUGIN_NAME).getPath();
        FileUtils.copyDirectoryToDirectory(new File(sourcePath), configPath);
    }

    @Test
    public void testIndex() {

    }

    @Test
    public void testTemplateWithMapping() throws IOException, ExecutionException, InterruptedException {
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
    public void testRestSearch() {

    }

    @Test
    public void testTransportClientSearch() {

    }
}
