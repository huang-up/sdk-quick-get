package com.huang.design.pattern.chapter25.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/23.
 */
public abstract class Colleague {
    protected static final Logger logger = LoggerFactory.getLogger(Colleague.class);
    protected Mediator mediator;
}
