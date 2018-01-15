package com.huang.design.pattern.chapter16.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/14.
 */
public abstract class State {
    protected static final Logger logger = LoggerFactory.getLogger(State.class);
    public abstract void writeProgram(Work work);
}
