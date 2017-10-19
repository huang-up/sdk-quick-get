package design.pattern.chapter22.bridge;

/**
 * Created by admin on 2017/10/19.
 */
public class ConcreteImplementorA extends Implementor {
    @Override
    public void operation() {
        super.logger.info("具体实现A的方法执行");
    }
}
