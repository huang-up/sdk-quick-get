package com.huang.design.pattern.chapter23.command;

/**
 * 命令模式(Command)：讲一个请求封装成一个对象，从而使你可用不同的请求对客户端进行参数化；
 * 对请求排队或记录请求日志，以及支持可撤销的操作。
 * 优点：
 * 1、它能较容易地设计一个命令队列。
 * 2、在需要的情况下，可以较容易地将命令记入日志
 * 3、允许接受请求的一方决定是否要否决请求
 * 4、可以容易地实现对请求的撤销和重做
 * 5、由于加进新的具体命令类不影响其他的类，因此增加新的命令类很容易
 * 6、命令模式把请求一个操作的对象与知道怎么执行一个操作的对象分割开
 *
 * 敏捷开发原则告诉我们，不要为代码添加基于猜测的、实际不需要的功能。
 * 如果不清楚一个系统是否需要命令模式，一般就不要着急去实现它，事实上，在需要的时候通过重构实现这个模式并不困难，
 * 只有在真正需要如撤销／恢复操作等功能时，把原来的代码重构为命令模式才有意义。
 * Created by h on 2017/10/22.
 */
public class AppClient {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command commad = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(commad);
        invoker.executeCommand();
    }
}