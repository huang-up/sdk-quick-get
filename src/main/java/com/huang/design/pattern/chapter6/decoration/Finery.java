package com.huang.design.pattern.chapter6.decoration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/9/19.
 */
public abstract class Finery extends Person {
    private static final Logger logger = LoggerFactory.getLogger(Finery.class);
    protected Person person;
    public Finery() {}
    public void decorate(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        if (person != null) {
            person.show();
        }
    }
}
