package com.huang.design.pattern.chapter26.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/25.
 */
public abstract class Flyweight {
    protected static final Logger logger = LoggerFactory.getLogger(Flyweight.class);
    public abstract void operation(int extrinsicstate);
}
