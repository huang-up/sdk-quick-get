package com.huang.design.pattern.chapter18.memento;

/**
 * 备忘录模式：在不破坏封装性的前提下，捕捉一个对象的内部状态，并在该对象之外保存这个状态，这样以后就可以将该对象恢复到原先保存的状态。
 *
 * 适用场合：
 * 功能比较复杂的，但需要维护或记录属性历史的类，或者需要保存的属性只是众多属性中的一小部分时，
 * Originnator 可以根据保存的 Memento 信息还原到前一状态。
 *
 * 如果在某个系统中使用命令模式时，需要实现命令的撤销功能，那么命令模式可以使用备忘录模式来存储可撤销操作的状态。
 * 有时一些对象的的内部信息必须保存在对象以外的地方，但是必须要由对象自己读取，这时使用备忘录可以把复杂的对象内部信息
 * 对其他的对象屏蔽起来，从而可以恰当地保持封装的边界。
 *
 * 最大的作用还是在当角色的状态改变的时候，有可能这个状态无效，这时候就可以使用暂时存储起来的备忘录将状态复原。
 *
 *
 *
 * Created by h on 2017/10/15.
 */
public class AppClient {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("on");
        originator.show();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("off");
        originator.show();

        originator.setMemento(caretaker.getMemento());
        originator.show();
    }
}
