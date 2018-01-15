package com.huang.design.pattern.chapter19.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/19.
 */
public abstract class Component {
    protected static final Logger logger = LoggerFactory.getLogger(Component.class);
    protected String name;
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);
}