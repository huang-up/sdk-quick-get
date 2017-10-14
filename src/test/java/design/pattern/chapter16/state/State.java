package design.pattern.chapter16.state;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/14.
 */
public abstract class State {
    protected static final Logger logger = Logger.getLogger(State.class);
    public abstract void writeProgram(Work work);
}
