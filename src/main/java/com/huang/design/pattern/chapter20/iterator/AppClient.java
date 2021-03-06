package com.huang.design.pattern.chapter20.iterator;

/**
 * 迭代器模式：提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。
 * 当你需要访问一个聚集对象，而且不管这些对象是什么都需要遍历的时候，你就应该考虑用迭代器模式。
 * 需要对聚集对象有多种方式遍历时，可以考虑用迭代器模式。
 * 为遍历不同的聚集结构提供如开始、下一个、是否结束、当前哪一项等统一的接口。
 *
 * 迭代器模式就是分离了集合对象的遍历行为，抽象出一个迭代器来负责，这样既可以做到不暴露集合的内部结构，
 * 又可以让外部透明地访问集合内部的数据。
 *
 * 迭代器模式在操作数组、集合、列表等数据时，尤其是数据库数据操作时，是非常普遍的应用，但由于它太普遍了，
 * 所以各种高级语言都对它进行了封装，所以反而给人感觉此模式太不常用了。
 *
 * Created by admin on 2017/10/18.
 */
public class AppClient {
}
