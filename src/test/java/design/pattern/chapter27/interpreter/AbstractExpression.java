package design.pattern.chapter27.interpreter;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/28.
 */
public abstract class AbstractExpression {
    protected static final Logger logger = Logger.getLogger(AbstractExpression.class);
    public abstract void interpret(Context context);
}
