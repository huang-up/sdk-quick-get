package com.huang.design.pattern.chapter24.chainofresponsibility.example;

/**
 * Created by h on 2017/10/23.
 */
public class Request {
    private String name;
    private String content;
    private String type;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
