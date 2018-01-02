package com.huang.design.pattern.chapter19.composite;

/**
 * 组合模式(Composite)：将对象组合成树形结构以表示"部分-整体"的层次结构。
 * 组合模式使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 为什么Leaf类当中也有Add和Remove，树叶不是不可以再长分支吗？
 *
 * 1、透明方式：在Component中声明所有用来管理子对象的方法，其中包括Add、Remove等。
 * 这样实现Component接口的所有子类都具备了Add和Remove。
 * 这样做好处就是叶节点和枝节点对于外界没有区别，它们具备完全一致的行为接口。
 * 但问题也很明显，因为Leaf类本身不具备Add、Remove方法的功能，所以实现它是没有意义的。
 *
 * 2、安全方式：在Component接口中不去声明Add和Remove方法，那么子类的Leaf也就不需要去实现它，
 * 而是在Composite声明所有用来管理子类对象的方法，这样做就不会出现刚才提到的问题，
 * 不过由于不够透明，所有树叶和树枝类将不具有相同的接口，客户端调用需要做相应的判断，带来了不便。
 * 两种方式视情况而定。
 *
 * 使用：
 * 需求中是体现部分与整体层次的结构时，以及你希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，
 * 就应该考虑用组合模式了。
 *
 * Created by h on 2017/10/19.
 */
public class AppClient {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));

        root.add(comp);

        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));

        root.add(comp2);

        root.add(new Leaf("Leaf C"));

        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        root.display(1);
    }
}
