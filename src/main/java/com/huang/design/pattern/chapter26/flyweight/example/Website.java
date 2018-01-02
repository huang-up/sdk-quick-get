package com.huang.design.pattern.chapter26.flyweight.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/25.
 */
public abstract class Website {
    protected static final Logger logger = Logger.getLogger(Website.class);
    public abstract void use(User user);
}
