package com.huang.design.pattern.chapter12.facade;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/9/27.
 */
public class Stock2 {
    private static final Logger logger = Logger.getLogger(Stock2.class);
    public void sell() {
        logger.info("股票2卖出");
    }
    public void buy() {
        logger.info("股票2买入");
    }
}
