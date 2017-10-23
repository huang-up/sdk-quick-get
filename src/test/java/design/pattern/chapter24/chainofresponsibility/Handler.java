package design.pattern.chapter24.chainofresponsibility;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/22.
 */
public abstract class Handler {
    protected static final Logger logger = Logger.getLogger(Handler.class);
    protected Handler successor;
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
    public abstract void handlerRequest(int request);
}
