package com.huang.design.pattern.chapter22.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/10/19.
 */
public abstract class Implementor {
    protected static final Logger logger = LoggerFactory.getLogger(Implementor.class);
    public abstract void operation();
}
