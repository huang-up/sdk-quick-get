package design.pattern.chapter26.flyweight;

/**
 * Created by h on 2017/10/25.
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        super.logger.info("具体Flyweight：" + extrinsicstate);
    }
}
