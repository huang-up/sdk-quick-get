package com.huang.design.pattern.chapter8.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/9/24.
 */
public class LeiFeng {
    private static final Logger logger = LoggerFactory.getLogger(LeiFeng.class);
    public void sweep() {
        logger.info("扫地");
    }

    public void wash() {
        logger.info("洗衣");
    }

    public void buyRice() {
        logger.info("买米");
    }
}
