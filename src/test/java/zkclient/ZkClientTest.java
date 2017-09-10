package zkclient;

import com.github.zkclient.IZkClient;
import com.github.zkclient.IZkDataListener;
import com.github.zkclient.IZkStateListener;
import com.github.zkclient.ZkClient;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.Charsets;
import org.apache.log4j.Logger;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by h on 2017/9/9.
 */
public class ZkClientTest {
    private final static Logger LOGGER = Logger.getLogger(ZkClientTest.class);
    //    private IZkClient zkClient = new ZkClient("127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002");
    private IZkClient zkClient;

    @Before
    public void initZkClient() {
        LOGGER.info("zkClient init start");
        zkClient = new ZkClient("127.0.0.1:2181");
        LOGGER.info("zkClient init finish ");
    }

    @After
    public void close() {
        LOGGER.info("zkClient close start");
        zkClient.close();
        LOGGER.info("zkClient close finish ");
    }

    @Test
    public void createNode() {
        LOGGER.info("create node");
//        zkClient.createPersistent("/persistent/sub/third");
        zkClient.createPersistent("/namespace/app");
    }

    @Test
    public void deleteNode() {
        LOGGER.info("delete node");
//        zkClient.delete("/persistent");
        zkClient.delete("/namespace");
    }

    @Test
    public void searchNode() {
        LOGGER.info("search node");
        LOGGER.info(zkClient.exists("/persistent"));
        LOGGER.info(new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS").format(new Date(zkClient.getCreationTime("/persistent"))));
        LOGGER.info(zkClient.getChildren("/persistent"));
        LOGGER.info(zkClient.countChildren("/persistent"));
    }

    @Test
    public void readData() {
        LOGGER.info("read data");
        LOGGER.info(StringUtils.newStringUtf8(zkClient.readData("/persistent")));
        LOGGER.info(StringUtils.newStringUtf8(zkClient.readData("/namespace")));
    }

    @Test
    public void writeData() {
        // 下面说到的显示是指在ZK UI中
        // 其中拥有子节点的为Node(在左侧显示name)，未拥有子节点的为property(在右侧显示name和value)
        LOGGER.info("write data");
        Stat stat = zkClient.writeData("/persistent", "当前节点(拥有子节点)name显示在左侧，value不显示".getBytes(Charsets.UTF_8));
        zkClient.writeData("/persistent/sub/third", "当前节点(未拥有子节点)name和value显示，显示在右侧".getBytes(Charsets.UTF_8));
        zkClient.writeData("/namespace", "01".getBytes(Charsets.UTF_8));
    }

    @Test
    public void subscribeDataChanges() {
        LOGGER.info("subscribe dataChanges");
        zkClient.subscribeDataChanges("/namespace", new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, byte[] data) throws Exception {
                LOGGER.info(String.format("%s data had changed to %s", dataPath, StringUtils.newStringUtf8(data)));
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                LOGGER.info(String.format("%s was deleted", dataPath));
            }
        });
        for (; ; ) {
        }
    }

    @Test
    public void subscribeStateChanges() {
        LOGGER.info("subscribe stateChanges");
        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                // do nothing, since zkclient will do reconnect for us.
            }

            @Override
            public void handleNewSession() throws Exception {
                // 例如在session失效时，需要重新注册broker以及其topics:
                /*
                logger.info("re-registering broker info in zookeeper for broker " + config.getBrokerId());
                registerBrokerInZk();
                synchronized (lock) {
                    logger.info("re-registering broker topics in zookeeper for broker " + config.getBrokerId());
                    for (String topic : topics) {
                        processTask(new TopicTask(TaskType.CREATE, topic));
                    }
                }
                */
            }
        });
    }
}
