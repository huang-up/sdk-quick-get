package com.huang.design.pattern.chapter6.decoration;


import org.apache.log4j.Logger;

/**
 * Created by admin on 2017/9/19.
 */
public class Person {
    private static final Logger logger = Logger.getLogger(Person.class);
    private String name;
    public Person() {
        logger.info("Person()");
    }
    public Person(String name) {
        logger.info("Person(String name)");
        this.name = name;
    }
    public void show() {
        logger.info(String.format("装饰的%s", name));
    }
}
