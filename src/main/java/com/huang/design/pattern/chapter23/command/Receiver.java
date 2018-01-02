package com.huang.design.pattern.chapter23.command;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/22.
 */
public class Receiver {
    private static final Logger logger = Logger.getLogger(Receiver.class);
    public void action(){
        logger.info("执行请求");
    }
}
