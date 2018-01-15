package com.huang.generic.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/11/2.
 */
public abstract class Person {
    protected static Logger logger = LoggerFactory.getLogger(Person.class);
    public abstract void run();
}
