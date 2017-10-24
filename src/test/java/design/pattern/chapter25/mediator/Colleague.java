package design.pattern.chapter25.mediator;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/23.
 */
public abstract class Colleague {
    protected static final Logger logger = Logger.getLogger(Colleague.class);
    protected Mediator mediator;
}
