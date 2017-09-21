package design.pattern.chapter6.decoration;

import org.apache.log4j.Logger;

/**
 * Created by admin on 2017/9/19.
 */
public abstract class Finery extends Person {
    private static final Logger logger = Logger.getLogger(Finery.class);
    protected Person person;
    public Finery() {}
    public void decorate(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        if (person != null) {
            person.show();
        }
    }
}
