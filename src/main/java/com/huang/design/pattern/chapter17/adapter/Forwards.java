package com.huang.design.pattern.chapter17.adapter;

/**
 * Created by h on 2017/10/15.
 */
public class Forwards extends Player {

    public Forwards(String name) {
        super.name = name;
    }

    @Override
    public void attack() {
        super.logger.info(String.format("前锋：%s 进攻", super.name));
    }

    @Override
    public void defence() {
        super.logger.info(String.format("前锋：%s 防守", super.name));
    }
}
