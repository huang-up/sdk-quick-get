package com.huang.design.pattern.chapter22.bridge.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/22.
 */
public abstract class HandsetBrand {
    protected static final Logger logger = LoggerFactory.getLogger(HandsetBrand.class);
    protected HandsetSoft handsetSoft;
    public void setHandsetSoft(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }
    public abstract void run();
}
