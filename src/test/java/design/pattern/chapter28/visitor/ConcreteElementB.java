package design.pattern.chapter28.visitor;

/**
 * Created by h on 2017/10/28.
 */
public class ConcreteElementB extends Element {
    @Override
    public void accept(Vistor vistor) {
        vistor.visitConcreteElementB(this);
    }
    public void operatironB() {

    }
}
