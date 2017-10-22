package design.pattern.chapter23.command;

/**
 * 命令模式(Command)：讲一个请求封装成一个对象，从而使你可用不同的请求对客户端进行参数化；
 * 对请求排队或记录请求日志，以及支持可撤销的操作。
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
