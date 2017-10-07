package design.pattern.chapter13.builder;

/**
 * 建造者模式（生成器模式）：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 建造者模式可以将一个产品的内部表象与产品的生成过程分割开来，从而可以使一个建造过程生成具有不同的内部表象的产品对象。
 *
 * 建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时适用的模式
 * 建造者模式主要用于创建一些复杂的对象，这些对象内部构建间的建造顺序通常是稳定的，但对象内部的构建通常面临这复杂的变化。
 *
 * 建造者模式的好处是使得建造代码与表示代码分离，由于建造者隐藏了该产品是如何组装的，所以若需要改变一个产品的内部表示，
 * 只需要再定义一个具体的建造者就可以了。
 *
 * 如果我们用了建造者模式，那么用户就只需指定需要建造的类型就可以得到它们，而具体建造的过程和细节就不需要知道了。
 *
 *
 * Created by h on 2017/9/27.
 */
public class AppClient {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        director.construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        director.construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}
