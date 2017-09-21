package design.pattern.chapter6.decoration;

import org.apache.log4j.Logger;

/**
 * Created by admin on 2017/9/19.
 */
public class BigTrouser extends Finery {
    private static final Logger logger = Logger.getLogger(BigTrouser.class);
    public BigTrouser() {}
    @Override
    public void show() {
        logger.info("BigTrouser");
        super.show();
    }
}
