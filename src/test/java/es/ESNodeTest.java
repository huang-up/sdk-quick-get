package es;

import org.apache.log4j.Logger;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeValidationException;
import org.elasticsearch.transport.Netty3Plugin;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by admin on 2017/12/26.
 */
public class ESNodeTest {

    private static final Logger logger = Logger.getLogger(ESNodeTest.class);
    private Node node;

    @Before
    public void startNode() throws NodeValidationException {
        logger.info("start es node");
        Settings settings = Settings.builder()
                .put("cluster.name", "my-es")
                .put("node.name", "node-1")
                .put("path.home", "D:\\es-node")
                .put("transport.type", "local")
                .put("http.enabled", true)
                .put("http.port", 9200)
                .put("http.cors.enabled", true)
                .put("http.cors.allow-origin", "*")
                .put("http.type", "netty3")
                .put("transport.tcp.port", 9300)
                .put("network.bind_host", "0.0.0.0").build();
        Collection plugins = Arrays.asList(Netty3Plugin.class);
        node = new PluginConfigurableNode(settings, plugins);
        node.start();
    }

    @Test
    public void testIndex() {
        logger.info(node.getEnvironment());
    }

    @Test
    public void testMapping() {

    }

    @Test
    public void testRestSearch() {

    }
}
