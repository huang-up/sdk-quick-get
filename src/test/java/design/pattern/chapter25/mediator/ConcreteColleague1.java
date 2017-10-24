package design.pattern.chapter25.mediator;

/**
 * Created by h on 2017/10/23.
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        this.mediator = mediator;
    }
    public void send(String message) {
        super.mediator.send(message, this);
    }
    public void beNotified(String message) {
        super.logger.info("同事1得到消息：" + message);
    }
}
