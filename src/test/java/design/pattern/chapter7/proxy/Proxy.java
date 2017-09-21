package design.pattern.chapter7.proxy;

/**
 * Created by h on 2017/9/19.
 * 依赖 Pursuit
 */
public class Proxy implements GiveGift {
    private Pursuit pursuit;
    public Proxy(SchoolGirl schoolGirl) {
        this.pursuit = new Pursuit("卓贾易", schoolGirl);
    }
    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }

}
