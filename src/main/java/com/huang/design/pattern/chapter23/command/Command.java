package com.huang.design.pattern.chapter23.command;

/**
 * Created by h on 2017/10/22.
 */
public abstract class Command {
    protected Receiver receiver;
    public abstract void executeCommand();
}
