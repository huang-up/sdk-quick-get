package design.pattern.chapter12.facade;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/9/27.
 */
public class NationalDebt1 {
    private static final Logger logger = Logger.getLogger(NationalDebt1.class);
    public void sell() {
        logger.info("国债1卖出");
    }
    public void buy() {
        logger.info("国债1买入");
    }
}
