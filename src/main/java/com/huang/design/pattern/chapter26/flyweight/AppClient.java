package com.huang.design.pattern.chapter26.flyweight;

/**
 * 享元模式(Flyweight)：运用共享技术有效地支持大量细粒度的对象。
 *
 * 在享元对象内部并且不会随环境改变而改变的共享部分，可以称为是享元对象的内部状态，而随环境改变而改变的、不可以共享的状态就是外部状态了。
 * 事实上，享元模式可以避免大量非常相似类的开销。
 * 在程序设计中，有时需要生成大量细粒度的类实例来表示数据。如果能发现这些实例除了几个参数外都是相同的，有时就能够大幅度地减少
 * 需要实例化的类的数量。如果能把那些参数移到类实例的外面，在方法调用时将它们传递进来，就可以通过共享大幅度地减少单个实例的数量。
 *
 * 也就是说，享元模式Flyweight执行时所需的状态是有内部的也可能有外部的，内部状态存储于ConcreteFlyweight对象之中，
 * 而外部状态则应该考虑由客户端对象存储和计算，当调用Flyweight对象的饿操作时，将该状态传递给它。
 *
 * 使用：
 * 1、如果一个应用程序使用了大量的对象，而大量的这些对象造成了很大的存储开销时就应该考虑使用；
 * 2、还有就是对象的大多数状态可以外部状态，如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象，此时可以考虑使用享元模式。
 *
 * 举例：
 * String titleA = "大话设计模式";
 * String titleB = "大话设计模式";
 * System.out.println(s1 == s2); // true
 * 如果每次创建字符串对象的时，都需要创建一个新的字符串的话，内存的开销会很大。
 * 所以如果第一次创建了字符串对象的titleA，下次再创建相同的字符串titleB时只是把它的引用指向'大话设计模式'，
 * 这样就实现了'大话设计模式'在内存中的共享。
 *
 * Created by h on 2017/10/25.
 */
public class AppClient {
    public static void main(String[] args) {
        int extrinsicstate = 22;
        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.operation(--extrinsicstate);

        Flyweight fy = f.getFlyweight("Y");
        fy.operation(--extrinsicstate);

        Flyweight fz = f.getFlyweight("Z");
        fz.operation(--extrinsicstate);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
        uf.operation(--extrinsicstate);

    }
}
