package design.pattern.chapter18.memento;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/19.
 */
public class Originator {
    private static final Logger logger = Logger.getLogger(Originator.class);
    private String state;
    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }
    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(this.state);
        return memento;
    }
    public void show() {
        logger.info(String.format("originator state is %s", this.state));
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
