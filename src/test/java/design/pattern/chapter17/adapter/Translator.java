package design.pattern.chapter17.adapter;

/**
 * Created by h on 2017/10/15.
 */
public class Translator extends Player {

    private ForeignCenter foreignCenter;
    public Translator(String name) {
        foreignCenter = new ForeignCenter(name);
    }

    @Override
    public void attack() {
        this.foreignCenter.attack();
    }

    @Override
    public void defence() {
        this.foreignCenter.defence();
    }
}
