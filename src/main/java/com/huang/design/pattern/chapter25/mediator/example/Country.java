package com.huang.design.pattern.chapter25.mediator.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/24.
 */
public abstract class Country {
    protected static final Logger logger = Logger.getLogger(Country.class);
    protected UnitedNations mediator;
}
