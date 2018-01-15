package com.huang.design.pattern.chapter23.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/22.
 */
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
    public void action(){
        logger.info("执行请求");
    }
}
