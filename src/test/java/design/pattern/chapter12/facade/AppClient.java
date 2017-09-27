package design.pattern.chapter12.facade;

import org.apache.log4j.Logger;

/**
 * 外观模式：
 *
 * 它完美地体现了依赖倒转原则和迪米特法则的思想，所以是非常常用的模式之一。
 *
 * 首先，在设计初期阶段，应该要有意识地将不同的两个层分离，比如经典的三层架构，就需要考虑在数据访问层和业务逻辑层、
 * 业务逻辑层和表示层的层与层之间建立外观Facade，这样可以为复杂的子系统提供一个简单的接口，使得耦合大大降低。
 * 其次，在开发阶段，子系统往往因为不断的重构演化而变得越来越复杂，大多数的模式使用时也都会产生很多小的类，这本是好事，
 * 但也给外部调用他们的用户程序带来了使用上的困难，增加外观Facade可以提供一个简单的接口，减少他们之间的依赖。
 * 第三，在维护一个遗留的大型系统时，可能这个系统已经非常难以维护和扩展了，但因为它包含了非常重要的功能，新的需求开发必须要依赖它。
 * 此时用外观模式Facade也是非常合适的。你可以开发一个外观Facade类，来提供设计粗糙或高度复杂的遗留代码的比较清晰简单的接口，
 * 让新系统与Facade对象交互，Facade与遗留代码交互所有复杂的工作。
 * Created by h on 2017/9/27.
 */
public class AppClient {
    private static final Logger logger = Logger.getLogger(AppClient.class);
    public static void main(String[] args) {
        Fund fund = new Fund();
        fund.buyFund();
        fund.sellFund();
    }
}
