package design.pattern.chapter28.visitor;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/28.
 */
public abstract class Vistor {
    protected static final Logger logger = Logger.getLogger(Vistor.class);
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
