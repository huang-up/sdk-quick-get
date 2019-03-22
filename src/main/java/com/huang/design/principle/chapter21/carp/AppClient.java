package com.huang.design.principle.chapter21.carp;

/**
 * 合成/聚合复用原则（CARP），尽量使用合成/聚合，尽量不要使用类继承。
 *
 * 对象的继承关系是在编译时就定义好了，所以无法在运行时改变从父类继承的实现。
 * 子类的实现与它的父类有非常紧密的依赖关系，以至于父类实现中的任何变化必然会导致子类发生变化。
 * 当你需要复用子类时，如果继承下来的子类不适合解决新的问题父类必须重写或者被其他更合适的类替换。
 * 这种依赖关系限制了灵活性并最终限制了复用性。
 *
 * 合成（Composition，也有翻译成组合）和聚合（Aggregation）都是关联的特殊种类。
 * 聚合表示一种弱的“拥有关系”，体现的是A对象可以包含B对象，但B对象不是A对象的一部分。
 * 合成则是一种强的“拥有关系”，体现了严格的部分和整体的关系，部分和整体的生命周期一样。
 *
 * 好处：
 * 优先使用对象的合成/聚合将有助于你保持每个类被封装，并被集中在单个任务上。
 * 这样类和类继承层次会保持较小的规模，并且不太可能增长为不可控制的庞然大物。
 *
 * Created by admin on 2017/10/18.
 */
public class AppClient {
}
