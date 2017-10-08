package design.pattern.chapter14.observer;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/8.
 */
public class StockObserver implements Observer {
    private String name;
    private Subject subject;
    private static final Logger logger = Logger.getLogger(StockObserver.class);
    public StockObserver() {}
    public StockObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }
    @Override
    public void update() {
        logger.info(String.format("%s %s 关闭股票行情，继续工作！", subject.getSubjectState(), name));
    }
}
