package com.huang.design.pattern.chapter28.visitor;

/**
 * Created by h on 2017/10/28.
 */
public class ConcreteVistor2 extends Vistor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        super.logger.info(String.format("%s被%s访问", concreteElementA.getClass().getName(), this.getClass().getName()));
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        super.logger.info(String.format("%s被%s访问", concreteElementB.getClass().getName(), this.getClass().getName()));
    }
}
