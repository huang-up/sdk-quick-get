package com.huang.design.pattern.chapter6.decoration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/9/19.
 */
public class BigTrouser extends Finery {
    private static final Logger logger = LoggerFactory.getLogger(BigTrouser.class);
    public BigTrouser() {}
    @Override
    public void show() {
        logger.info("BigTrouser");
        super.show();
    }
}
