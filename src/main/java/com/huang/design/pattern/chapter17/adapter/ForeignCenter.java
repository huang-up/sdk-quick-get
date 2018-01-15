package com.huang.design.pattern.chapter17.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/15.
 */
public class ForeignCenter{
    private final static Logger logger = LoggerFactory.getLogger(ForeignCenter.class);
    private String name;
    public ForeignCenter(String name) {
        this.name = name;
    }

    public void attack() {
        logger.info(String.format("外籍中锋：%s 进攻", this.name));
    }

    public void defence() {
        logger.info(String.format("外籍中锋：%s 防守", this.name));
    }
}
