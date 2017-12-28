package es;

import org.apache.log4j.Logger;
import org.elasticsearch.node.Node;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by admin on 2017/12/26.
 */
public class ESNodeTest {

    private static final Logger logger = Logger.getLogger(ESNodeTest.class);
    private Node node;

    @Before
    public void startNode() {
        logger.info("start es node");

    }

    @Test
    public void testIndex() {

    }

    @Test
    public void testMapping() {

    }

    @Test
    public void testRestSearch() {

    }
}
