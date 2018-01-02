package com.huang.design.pattern.chapter24.chainofresponsibility;

/**
 * Created by h on 2017/10/22.
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handlerRequest(int request) {
        if (request >= 10 && request < 20) {
            super.logger.info(String.format("%s 处理请求 %d",this.getClass().getName(), request));
        } else if (successor != null) {
            successor.handlerRequest(request);
        }
    }
}