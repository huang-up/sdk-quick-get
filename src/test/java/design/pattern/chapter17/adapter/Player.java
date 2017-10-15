package design.pattern.chapter17.adapter;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/15.
 */
public abstract class Player {
    protected final static Logger logger = Logger.getLogger(Player.class);
    protected String name;
    public abstract void attack();
    public abstract void defence();
}
