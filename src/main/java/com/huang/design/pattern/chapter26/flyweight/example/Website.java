package com.huang.design.pattern.chapter26.flyweight.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/25.
 */
public abstract class Website {
    protected static final Logger logger = LoggerFactory.getLogger(Website.class);
    public abstract void use(User user);
}
