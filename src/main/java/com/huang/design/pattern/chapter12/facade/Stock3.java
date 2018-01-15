package com.huang.design.pattern.chapter12.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/9/27.
 */
public class Stock3 {
    private static final Logger logger = LoggerFactory.getLogger(Stock3.class);
    public void sell() {
        logger.info("股票3卖出");
    }
    public void buy() {
        logger.info("股票3买入");
    }
}
