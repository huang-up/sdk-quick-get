package com.huang.design.pattern.chapter28.visitor;

/**
 * Created by h on 2017/10/28.
 */
public class ConcreteElementA extends Element {
    @Override
    public void accept(Vistor vistor) {
        vistor.visitConcreteElementA(this);
    }
    public void operatironA() {

    }
}
