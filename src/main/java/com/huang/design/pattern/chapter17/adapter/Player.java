package com.huang.design.pattern.chapter17.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/15.
 */
public abstract class Player {
    protected final static Logger logger = LoggerFactory.getLogger(Player.class);
    protected String name;
    public abstract void attack();
    public abstract void defence();
}
