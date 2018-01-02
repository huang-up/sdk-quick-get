package com.huang.design.pattern.chapter2.strategy;

/**
 * Created by h on 2017/9/23.
 */
public class CashNormal extends CashSuper {
    @Override
    double acceptCash(double money) {
        return money;
    }
}
