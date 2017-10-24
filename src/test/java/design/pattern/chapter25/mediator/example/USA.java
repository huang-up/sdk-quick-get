package design.pattern.chapter25.mediator.example;

/**
 * Created by h on 2017/10/24.
 */
public class USA extends Country {
    public USA(UnitedNations mediator) {
        super.mediator = mediator;

    }
    public void declare(String message) {
        super.mediator.declare(message, this);
    }
    public void getMessage(String message) {
        super.logger.info("美国得到对方消息：" + message);
    }
}
