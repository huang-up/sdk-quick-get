package com.huang.design.pattern.chapter8.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。
 *
 * 工厂方法模式实现时，客户端需要决定实例化哪一个工厂来实现运算类，选择判断的问题还是存在的，也就是说，
 * 工厂方法把简单工厂的内部判断逻辑移到客户端代码中来进行。你想要加功能，本来是修改工厂类的，现在是修改客户端！
 *
 * 工厂方法模式克服了简单工厂违背了开放-封闭原则的缺点，又保持了封装对象创建过程的优点。
 * 工厂方法模式是简单工厂模式的进一步的抽象和推广。
 *
 * 缺点：
 * 每增加一个产品，就需要增加一个产品工厂的类，增加类额外的工作量。
 * 没有办法避免修改客户端的代码。
 *
 * 利用"反射"可以避免分支判断的问题。
 *
 * Created by h on 2017/9/23.
 */
public class AppClient {
    private static final Logger logger = LoggerFactory.getLogger(AppClient.class);
    public static void main(String[] args) {
        IFactory iFactory = new UndergraduateFactory();
        LeiFeng leiFeng = iFactory.createLeiFeng();
        leiFeng.sweep();
        leiFeng.wash();
        leiFeng.buyRice();
    }
}
