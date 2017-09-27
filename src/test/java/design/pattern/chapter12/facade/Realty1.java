package design.pattern.chapter12.facade;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/9/27.
 */
public class Realty1 {
    private static final Logger logger = Logger.getLogger(Realty1.class);
    public void sell() {
        logger.info("房地产1卖出");
    }
    public void buy() {
        logger.info("房地产1买入");
    }
}
