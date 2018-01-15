package com.huang.design.pattern.chapter23.command.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/22.
 */
public class Barbecuer {
    private static final Logger logger = LoggerFactory.getLogger(Barbecuer.class);
    public void bakeMutton() {
        logger.info("烤羊肉串");
    }
    public void bakeChickenWing() {
        logger.info("烤鸡翅");
    }
}
