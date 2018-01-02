package com.huang.design.pattern.chapter25.mediator;

/**
 * 中介者模式(Mediator)：用一个中介对象来封装一系列的对象交互。
 * 中介者使各对象不需要显示地相互引用,从而使其耦合松散,而且可以独立地改变你它们之间的交互。
 *
 * 中介者模式很容易在系统中应用，也很容易在系统中误用。当系统中出现来'多对多'交互复杂的对象群时，不要急于使用
 * 中介者模式，而要先反思你的系统在设计上是不是合理。
 *
 * 优点：
 * 1、首先是Mediator的出现减少来各个Colleague的耦合，使得可以独立地改变和复用各个Colleague类和Mediator，比如
 * 任何国家的改变不会影响到其他国家，而只是与安理会发生变化。
 * 2、其次，由于把对象如何协作进行类抽象，将中介作为一个独立的概念并将其封装在一个对象中，这样关注的对象就从对象各自
 * 本身的行为转移到它们之间的交互上来，也就是站在一个更宏观的角度看待系统。
 *
 * 缺点：
 * 1、由于ConcereteMediator控制了集中化，于是就把交互复杂性变味了中介者的复杂性，这就使得中介者会变得比任何一个
 * ConcreteColleague都复杂。
 *
 * 应用：
 * 中介者模式一般应用于一组对象以定义良好但是复杂的方式进行通信的场合，以及想定制一个分布在多个类中的行为，
 * 而又不想生成太多的子类的场合。
 *
 * Created by h on 2017/10/23.
 */
public class AppClient {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        c1.send("吃饭了吗？");
        c2.send("没有呢，你打算请客？");
    }
}
