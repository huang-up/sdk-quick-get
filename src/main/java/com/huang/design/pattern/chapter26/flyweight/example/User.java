package com.huang.design.pattern.chapter26.flyweight.example;

/**
 * Created by h on 2017/10/25.
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
