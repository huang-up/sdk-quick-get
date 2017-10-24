package design.pattern.chapter25.mediator;

/**
 * Created by h on 2017/10/23.
 */
public abstract class Mediator {
    public abstract void send(String message, Colleague colleague);
}
