package com.huang.design.pattern.chapter2.strategy;

/**
 * Created by h on 2017/9/23.
 */
public class CashRebate extends CashSuper {
    private double moneyRebate;
    private CashRebate() {}
    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }
    @Override
    double acceptCash(double money) {
        return money * moneyRebate;
    }
}
