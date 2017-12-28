package generic.array;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/11/2.
 */
public abstract class Person {
    protected static Logger logger = Logger.getLogger(Person.class);
    public abstract void run();
}
