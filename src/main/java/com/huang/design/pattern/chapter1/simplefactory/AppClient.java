package com.huang.design.pattern.chapter1.simplefactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单工厂模式的最大优点在于工厂类中包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类，
 * 对于客户端来说，去除了与具体产品的依赖。
 *
 * 就像计算器，让客户端不用管该用哪个类的实例，只需要吧"+"给工厂，工厂自动给出了相应的实例，
 * 客户端只要去运算就可以了，不同的实例会实现不同的算法。
 * 但问题也有，如果要加一个"求M数的N次方"的功能，我们需要给运算工厂类的方法里加"case"的分支条件，修改原有的类？
 * 这可不是好办法，这就等于说，我们不但对扩展开放了，对修改也开放了，这就违背了开放-封闭原则。于是工厂方法就来了。
 *
 * Created by h on 2017/9/21.
 */
public class AppClient {
    private static final Logger logger = LoggerFactory.getLogger(AppClient.class);
    public static void main(String[] args) {
        logger.info(String.valueOf(getResult(1,2,"+")));
    }

    public static double getResult(double numA, double numB, String operate) {
        Operation operation = OperationFactory.createOperate(operate);
        operation.numA = numA;
        operation.numB = numB;
        return operation.getResult();
    }
}
