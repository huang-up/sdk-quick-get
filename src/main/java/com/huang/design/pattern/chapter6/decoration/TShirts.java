package com.huang.design.pattern.chapter6.decoration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/9/19.
 */
public class TShirts extends Finery {
    private static final Logger logger = LoggerFactory.getLogger(TShirts.class);
    public TShirts() {}
    @Override
    public void show() {
       logger.info("TShirts");
       super.show();
    }
}
