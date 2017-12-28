package design.pattern.chapter28.visitor;

/**
 * 访问这模式(Vistor)：表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 * 访问者模式适用于数据结构相对稳定的系统。它把数据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由地演化。
 *
 * 访问者模式的目的是要把处理从数据结构分离出来。很多系统可以按照算法和数据结构分开，如果这样的系统有比较稳定的数据结构，又有
 * 易于变化的算法的话，使用访问者模式就是比较合适的，因为访问者模式使得算法操作的增加变得容易。反之，如果这样的系统的数据结构
 * 对象易于变化，经常要有新的数据对象增加进来，就不适合使用访问者模式。
 *
 * 优点
 * 访问者模式的就是增加新的操作很容易，因为增加新的操作就意味着增加一个新的访问者。访问者模式将有关的行为集中到一个访问者对象中。
 *
 * 缺点
 * 访问者的缺点其实也就是使增加新的数据结构变得困难了。
 *
 *
 * Created by h on 2017/10/28.
 */
public class AppClient {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());
        ConcreteVistor1 v1 = new ConcreteVistor1();
        ConcreteVistor2 v2 = new ConcreteVistor2();

        o.accept(v1);
        o.accept(v2);
    }
}
