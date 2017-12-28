package design.pattern.chapter26.flyweight;

/**
 * Created by h on 2017/10/25.
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        super.logger.info("不共享的具体Flyweight：" + extrinsicstate);
    }
}
