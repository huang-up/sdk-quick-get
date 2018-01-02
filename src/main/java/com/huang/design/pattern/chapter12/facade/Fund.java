package com.huang.design.pattern.chapter12.facade;

/**
 * Created by h on 2017/9/27.
 */
public class Fund {
    private Stock1 stock1;
    private Stock2 stock2;
    private Stock3 stock3;
    private NationalDebt1 nationalDebt1;
    private Realty1 realty1;

    public Fund() {
        stock1 = new Stock1();
        stock2 = new Stock2();
        stock3 = new Stock3();
        nationalDebt1 = new NationalDebt1();
        realty1 = new Realty1();
    }

    public void buyFund() {
        this.stock1.buy();
        this.stock2.buy();
        this.stock3.buy();
        this.nationalDebt1.buy();
        this.realty1.buy();
    }

    public void sellFund() {
        this.stock1.sell();
        this.stock2.sell();
        this.stock3.sell();
        this.nationalDebt1.sell();
        this.realty1.sell();
    }

}
