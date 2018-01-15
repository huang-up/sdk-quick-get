package com.huang.design.pattern.chapter25.mediator.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/24.
 */
public abstract class Country {
    protected static final Logger logger = LoggerFactory.getLogger(Country.class);
    protected UnitedNations mediator;
}
