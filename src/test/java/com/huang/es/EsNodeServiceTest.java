package com.huang.es;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by h on 2018/4/6.
 */
@Slf4j
public class EsNodeServiceTest {

    @Test
    public void testRestSearch() throws IOException {
        // normal rest-client
        RestClient restClient = RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
                .setMaxRetryTimeoutMillis(3000).build();
        Response response = restClient.performRequest("GET", "/_search");
        log.info(EntityUtils.toString(response.getEntity()));


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
    public void testTransportClientSearch() throws UnknownHostException {
/*
        String host = System.getProperty("host");
        int port = Integer.parseInt(System.getProperty("port", "9343"));

        String hostBasedClusterName = host.split("\\.", 2)[0];
        String clusterName = System.getProperty("cluster", hostBasedClusterName);

        boolean enableSsl = Boolean.parseBoolean(System.getProperty("ssl", "true"));
        // Note: If enabling IPv6, then you should ensure that your host and network can route it to the Cloud endpoint.
        // (eg Docker disables IPv6 routing by default) - see also the initialization code at the top of this file.
        boolean ip6Enabled = Boolean.parseBoolean(System.getProperty("ip6", "true"));
        boolean ip4Enabled = Boolean.parseBoolean(System.getProperty("ip4", "true"));

        // For testing in dev environments, similar to `curl -k` option
        boolean insecure = Boolean.parseBoolean(System.getProperty("insecure", "false"));

        log.info("Connecting to cluster: [{}] via [{}:{}] using ssl:[{}]", clusterName, host, port, enableSsl);
*/
        boolean enableSsl = Boolean.parseBoolean(System.getProperty("ssl", "true"));

        // Note that you have to set the cluster name if you use one different than "elasticsearch":
        Settings settings = Settings.builder()
                .put("cluster.name", "my-es")
        // Set to true to ignore cluster name validation of connected nodes.
//                .put("client.transport.ignore_cluster_name", true)
        // discover available data nodes only on those nodes (addTransportAddress), refreshed every five seconds by default
                .put("client.transport.sniff", false)
                .put("transport.tcp.compress", true)
//                .put("transport.type", "netty3")
//                .put("http.type", "netty3")
//                .put("xpack.security.transport.ssl.enabled", enableSsl)
//                .put("request.headers.X-Found-Cluster", "${cluster.name}")
//                .put("xpack.security.user", System.getProperty("xpack.security.user"))
//                .put("xpack.security.transport.ssl.verification_mode", insecure ? "none" : "full")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","kimchy");
        json.put("postDate",new Date());
        json.put("message","trying out Elasticsearch");


        IndexResponse response = client.prepareIndex("twitter", "tweet", "1").setSource(json, XContentType.JSON).get();
        // you don’t have to give an ID
//        IndexResponse response = client.prepareIndex("twitter", "tweet").setSource(json, XContentType.JSON).get();

        /*client.index(new IndexRequest(), new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });*/

        // on shutdown
        client.close();
    }
}
