package com.huang.design.pattern.chapter24.chainofresponsibility;

/**
 * 责任链模式(Chain of Responsibility):使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 * 这里发出这个请求的客户端并不知道这当中的哪一个对象最终处理这个请求，这样系统的更改可以在不影响客户端的情况下
 * 动态地重新组织和分配责任。
 *
 * 好处：
 * 1、当客户提交一个请求时，请求是沿链传递直至有一个ConcreteHandler对象负责处理它。
 * 这样使得接收者和发送者都没有对方的明确信息，且链中的对象自己也并不知道链的结构。结果是职责链可简化对象的相互连接，
 * 它们仅需保持一个指向其后继者的引用，而不需保持它所有的候选接收者的引用。这也就大大降低了耦合度。
 * 2、由于是客户端来定义链的结构，也就是说，我可以随时地增加或修改处理一个请求的结构。增强了给对象指派职责的灵活性。
 * 不过一个请求极有可能到了链的末端都得不到处理，或者因为没有正确配置而得不到处理。
 *
 * Created by h on 2017/10/22.
 */
public class AppClient {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        int[] requests = {2,5,14,22,18,3,27,20};
        for (int request:requests) {
            h1.handlerRequest(request);
        }
    }
}
