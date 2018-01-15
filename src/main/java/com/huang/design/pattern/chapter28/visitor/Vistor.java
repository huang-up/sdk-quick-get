package com.huang.design.pattern.chapter28.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/28.
 */
public abstract class Vistor {
    protected static final Logger logger = LoggerFactory.getLogger(Vistor.class);
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
