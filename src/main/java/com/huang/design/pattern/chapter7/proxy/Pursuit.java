package com.huang.design.pattern.chapter7.proxy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/9/19.
 * Pursuit 依赖 SchoolGirl
 */
public class Pursuit implements GiveGift {
    private Logger logger = LoggerFactory.getLogger(Pursuit.class);
    private String name;
    private SchoolGirl schoolGirl;
    public Pursuit(String name, SchoolGirl schoolGirl) {
        this.name = name;
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDolls() {
        logger.info(String.format("%s 送 %s 洋娃娃。", name, schoolGirl.getName()));
    }

    @Override
    public void giveFlowers() {
        logger.info(String.format("%s 送 %s 鲜花。", name, schoolGirl.getName()));
    }

    @Override
    public void giveChocolate() {
        logger.info(String.format("%s 送 %s 巧克力。", name, schoolGirl.getName()));
    }

}
