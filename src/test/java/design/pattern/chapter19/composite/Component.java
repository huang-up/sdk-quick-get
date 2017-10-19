package design.pattern.chapter19.composite;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/19.
 */
public abstract class Component {
    protected static final Logger logger = Logger.getLogger(Component.class);
    protected String name;
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);
}