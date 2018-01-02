package com.huang.design.pattern.chapter13.builder;

/**
 * Created by h on 2017/9/29.
 */
public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}
