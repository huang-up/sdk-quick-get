package com.huang.design.pattern.chapter2.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 策略模式：定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户。
 *
 * 策略模式是用来封装算法的，但在实践中，我们发现可以用它来封装几乎任何类型的规则，
 * 只要在分析过程中听到需要在不同时间应用不同的业务规则，就可以考虑用策略模式处理这种变化的可能性。
 * 但在基本的策略模式中，选择所用具体实现的职责由客户端对象承担，并转给策略模式的Context对象。
 * 这本身没有解除客户端需要选择判断的压力，而策略模式和简单工厂模式结合后，选择具体实现的职责也可以由Context来承担，
 * 这就最大化地减轻了客户端的职责。
 *
 * 策略模式的优点：
 * 1、策略模式的 Strategy 类层次为 Context 定义了一系列的可供重用的算法或行为。继承有助于析取出这些算法的公共功能。
 * 2、简化了单元测试，因为每个算法都有自己的类，可以通过自己的接口单独测试。
 *
 * 高手和菜鸟的区别就是高手可以花同样的代价获得最大的收益或者说同样的事花最小的代价
 *
 * 反射反射，程序员的快乐。
 *
 * Created by admin on 2017/9/21.
 */
public class AppClient {
    private static final Logger logger = LoggerFactory.getLogger(AppClient.class);
    public static void main(String[] args) {
        CashContext cashContext = new CashContext("打8折");
        logger.info(String.valueOf(cashContext.getResult(100d)));
    }
}
