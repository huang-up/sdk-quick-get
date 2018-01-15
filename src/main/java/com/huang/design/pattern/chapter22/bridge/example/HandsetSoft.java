package com.huang.design.pattern.chapter22.bridge.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/22.
 */
public abstract class HandsetSoft {
    protected static final Logger logger = LoggerFactory.getLogger(HandsetSoft.class);
    public abstract void run();
}
