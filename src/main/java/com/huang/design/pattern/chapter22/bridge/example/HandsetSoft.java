package com.huang.design.pattern.chapter22.bridge.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/22.
 */
public abstract class HandsetSoft {
    protected static final Logger logger = Logger.getLogger(HandsetSoft.class);
    public abstract void run();
}
