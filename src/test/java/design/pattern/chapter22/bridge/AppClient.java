package design.pattern.chapter22.bridge;

/**
 * 桥接模式：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 什么叫抽象与它的实现分离，这并不是说，让抽象类与其派生类分离，因为这没有任何意义。
 * 实现指的是抽象类和它的派生类用来实现自己的对象。就刚才的例子而言，就是让“手机”既可以按照品牌来分类，
 * 也可以按照功能（软件）来分离。
 * 由于实现的方式有多种，桥接模式的核心意图就是把这些实现独立出来，让它们各自地变化，这就使得每种实现
 * 的变化不会影响其他实现，从而达到应对变化的目的。
 *
 * 实现系统可能有多角度分类，每一种分类都有可能变化，那么就把这种多角度分离出来让它们独立变化，
 * 减少它们之间的耦合。
 * 在我们发现需要多角度去分类实现对象，而只用继承会造成大量的类增加，不能满足开放-封闭原则时，
 * 就应该考虑用桥接模式。
 *
 *
 * Created by admin on 2017/10/19.
 */
public class AppClient {
    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction();
        abstraction.setImplementor(new ConcreteImplementorA());
        abstraction.operation();
    }
}
