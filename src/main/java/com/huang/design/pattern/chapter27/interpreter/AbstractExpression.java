package com.huang.design.pattern.chapter27.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/28.
 */
public abstract class AbstractExpression {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractExpression.class);
    public abstract void interpret(Context context);
}
