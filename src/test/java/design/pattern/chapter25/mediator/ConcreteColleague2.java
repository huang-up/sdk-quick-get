package design.pattern.chapter25.mediator;

/**
 * Created by h on 2017/10/23.
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        this.mediator = mediator;
    }
    public void send(String message) {
        super.mediator.send(message, this);
    }
    public void beNotified(String message) {
        super.logger.info("同事2得到消息：" + message);
    }
}
