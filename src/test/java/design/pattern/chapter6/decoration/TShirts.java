package design.pattern.chapter6.decoration;

import org.apache.log4j.Logger;

/**
 * Created by admin on 2017/9/19.
 */
public class TShirts extends Finery {
    private static final Logger logger = Logger.getLogger(TShirts.class);
    public TShirts() {}
    @Override
    public void show() {
       logger.info("TShirts");
       super.show();
    }
}
