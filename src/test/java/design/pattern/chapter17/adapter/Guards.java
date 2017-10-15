package design.pattern.chapter17.adapter;

/**
 * Created by h on 2017/10/15.
 */
public class Guards extends Player {

    public Guards(String name) {
        super.name = name;
    }

    @Override
    public void attack() {
        super.logger.info(String.format("后卫：%s 进攻", super.name));
    }

    @Override
    public void defence() {
        super.logger.info(String.format("后卫：%s 防守", super.name));
    }
}
