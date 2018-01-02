package com.huang.design.pattern.chapter24.chainofresponsibility.example;

/**
 * Created by h on 2017/10/23.
 */
public class Majordomo extends Manager {
    public Majordomo(String name) {
        super.name = name;
    }
    @Override
    public void requestApplication(Request request) {
        if ("请假".equals(request.getType()) && request.getNumber() <= 5) {
            super.logger.info(String.format("%s: %s 数量 %d 被批准",
                    this.getClass().getName(), request.getContent(), request.getNumber()));
        } else if (super.superior != null) {
            super.superior.requestApplication(request);
        }
    }
}
