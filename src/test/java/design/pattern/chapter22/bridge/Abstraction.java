package design.pattern.chapter22.bridge;

/**
 * Created by admin on 2017/10/19.
 */
public abstract class Abstraction {
    protected Implementor implementor;
    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
    public void operation() {
        implementor.operation();
    }
}
