package design.pattern.chapter23.command.example;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by h on 2017/10/22.
 */
public class Waiter {
    private static final Logger logger = Logger.getLogger(Waiter.class);
    private List<Command> commandList = new ArrayList<Command>();
    public void setOrder(Command command) {
        if(command.name.equals("烤鸡翅")) {
            logger.info("服务员：鸡翅没有了，请点其他的烧烤");
        } else {
            commandList.add(command);
            logger.info(String.format("增加订单，时间：%s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        }
    }
    public void cancleOrder(Command command) {
        commandList.remove(command);
        logger.info(String.format("取消订单，时间：%s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }
    public void notifyExecute() {
        for (Command command:commandList) {
            command.executeCommand();
        }
    }
}
