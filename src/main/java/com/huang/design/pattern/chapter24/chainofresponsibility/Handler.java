package com.huang.design.pattern.chapter24.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/22.
 */
public abstract class Handler {
    protected static final Logger logger = LoggerFactory.getLogger(Handler.class);
    protected Handler successor;
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
    public abstract void handlerRequest(int request);
}
