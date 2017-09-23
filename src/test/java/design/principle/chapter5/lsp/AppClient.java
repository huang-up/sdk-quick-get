package design.principle.chapter5.lsp;

/**
 * 里氏代换原则：子类型必须能够替换掉它们的父类型。
 * 一个软件实体如果使用的是一个父类的话，那么一定适用于其子类，而且察觉不出父类对象和子类对象的区别。
 * 也就是说，在软件里面，把父类都替换成它的子类，程序的行为没有变化。
 *
 * 也正是因为有了这个原则，使得继承复用成为了可能，只有子类可以替换掉父类，软件单位的功能不受到影响时，
 * 父类才能真正被复用，而子类也能够在父类的基础上增加新的行为。
 *
 * 由于里氏代换原则，才使得开放-封闭原则成为了可能。正是由于子类型的可替换性才使得父类类型的模块在无需修改的情况下就可以扩展。
 *
 * Created by admin on 2017/9/21.
 */
public class AppClient {
}
