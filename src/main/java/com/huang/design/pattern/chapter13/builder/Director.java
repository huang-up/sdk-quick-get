package com.huang.design.pattern.chapter13.builder;

/**
 * Created by h on 2017/9/30.
 */
public class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
