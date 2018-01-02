package com.huang.design.pattern.chapter15.abstractfactory;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，无需指定它们具体的类。
 * Ifactory 是一个抽象工厂接口，它里面应该包含所有的产品创建的抽象方法。
 * 而 ConcreteFactory1 和 ConcreteFactory2 就是具体的工厂了。就像 SqlServerFactory 和 AccessFactory 一样。
 *
 * 通常是在运行时刻再创建一个 ConcreteFactory 类的实例，这个具体的工厂再创建具有特定实现的产品对象，也就是说，
 * 为创建不同的产品对象，客户端应使用不同的具体工程工行。
 *
 * 好处：
 * 1、易于交换产品系列，由于具体工厂类，例如 Ifactory factory = new AccessFactory(),在一个应用中只需要在初始化的时候出现一次，
 * 这就使得改变一个应用的具体工厂变得非常容易，它只需要改变具体工厂即可使用不同的产品配置。
 * 2、它让具体的创建实例过程与客户端分离，客户端是通过它们的抽象接口操纵实例，产品的具体类名也被具体工厂的实现分离，不会出现在客户代码中。
 *
 * 缺点：
 * 1、需求增加功能，那至少要增加三个类，IProject、SqlServerProject、AccessProject，还需要更改IFactory、SqlServerFactory和
 * AccessFactory才可以完全实现。
 * 2、还有这样的设计，每一个类的开始都需要声明IFactory factory = new SqlServerFactory(),如果有100个调用数据库的类，就要更改100次
 * IFactory factory = new AccessFactory()才行，不能解决我们更改数据库时，改动一处就完全更改的要求。这样大批量的改动，显然是非常
 * 丑陋的做法。
 *
 * 所有在用简单工厂的地方，都可以考虑反射技术来去除switch或if，解除分支判断带来的耦合。
 *
 *
 * Created by h on 2017/10/11.
 */
public class AppClient {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        User user = new User();
        IUser iUser = DataAccess.createUser();
        iUser.insert(user);
        iUser.getuser(1);

//        用反射+抽象工厂
        ResourceBundle rb = ResourceBundle.getBundle("db");
        String db = rb.getString("db");
        Class factory = Class.forName("design.pattern.chapter15.abstractfactory."+db+"User");
        IUser iUser1 = (IUser) factory.newInstance();
        iUser1.insert(user);

    }
}
