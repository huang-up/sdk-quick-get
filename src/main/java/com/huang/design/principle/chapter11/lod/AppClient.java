package com.huang.design.principle.chapter11.lod;

/**
 * 迪米特法则（最少知识原则）：如果两个类不必彼此直接通信，那么这两个类就不应当发生直接的相互作用。
 * 如果其中一个类需要调用另一个类的某一个方法的话，可以通过第三者转发这个调用。
 *
 * 迪米特法则首先强调的前提是在类的结构的设计上，每一个类都应当降低成员的访问权限，也就是说
 * 一个类包装好自己的private状态，不需要让别的类知道的字段或行为就不要公开。
 *
 * 迪米特法则其根本思想，是强调了类之间的松耦合。
 * 类之间的耦合越弱，越有利于复用，一个处于弱耦合的类被修改，不会对有关系的类造成波及。也就是说，
 * 信息的隐藏促进了软件的复用。
 *
 * Created by h on 2017/9/26.
 */
public class AppClient {
}
