package design.pattern.chapter23.command.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/22.
 */
public class Barbecuer {
    private static final Logger logger = Logger.getLogger(Barbecuer.class);
    public void bakeMutton() {
        logger.info("烤羊肉串");
    }
    public void bakeChickenWing() {
        logger.info("烤鸡翅");
    }
}
