package design.pattern.chapter22.bridge;

import org.apache.log4j.Logger;

/**
 * Created by admin on 2017/10/19.
 */
public abstract class Implementor {
    protected static final Logger logger = Logger.getLogger(Implementor.class);
    public abstract void operation();
}
