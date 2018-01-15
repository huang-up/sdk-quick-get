package com.huang.design.pattern.chapter24.chainofresponsibility.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/23.
 */
public abstract class Manager {
    protected static final Logger logger = LoggerFactory.getLogger(Manager.class);
    protected String name;
//    管理者的上级
    protected Manager superior;
//    设置管理者的上级
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }
    public abstract void requestApplication(Request request);
}
