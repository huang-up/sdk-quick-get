package com.huang.design.pattern.chapter6.decoration;

/**
 * 装饰模式：动态地给一个对象添加一些额外的职能，就增加功能来说，装饰模式比生成子类更为灵活。
 *
 * 优点：把类中的装饰功能从类中搬移去除，这样可以简化原有的类。换句话说，当系统需要新功能的时候，是要向旧的类中添加新的代码。
 * 这些新加的代码通常装饰了原有类的核心职责和主要行为，他们在主类中加入了新的字段，新的方法和新的逻辑，从而增加类主类的负责度，
 * 而这些新加入的东西仅是为了满足一些只在某种特定情况下才会执行的特殊行为的需要。而装饰模式提供了非常好的解决方案，
 * 它把每个要装饰的功能放在单独的类中，并让这个类包装它所要装饰的对象，因此，当需要执行特殊行为时，
 * 客户代码就可以在运行时根据需要有选择地、按顺序地使用包装对象。
 *
 * 好处：有效地把累的核心职责和装饰功能区分开来。而且可以去除相关类中重复的装饰逻辑。
 *
 * Created by admin on 2017/9/19.
 */
public class AppClient {
    public static void main(String[] args) {
        Person person = new Person("小菜");
        TShirts tShirts = new TShirts();
        tShirts.decorate(person);
        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.decorate(tShirts);
        bigTrouser.show();
    }
}
