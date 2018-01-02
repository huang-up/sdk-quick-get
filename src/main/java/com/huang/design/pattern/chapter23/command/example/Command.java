package com.huang.design.pattern.chapter23.command.example;

/**
 * Created by h on 2017/10/22.
 */
public abstract class Command {
    protected String name;
    protected Barbecuer barbecuer;
    public abstract void executeCommand();
}
