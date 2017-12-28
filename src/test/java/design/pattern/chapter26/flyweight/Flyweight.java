package design.pattern.chapter26.flyweight;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/25.
 */
public abstract class Flyweight {
    protected static final Logger logger = Logger.getLogger(Flyweight.class);
    public abstract void operation(int extrinsicstate);
}
