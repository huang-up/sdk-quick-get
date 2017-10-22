package design.pattern.chapter22.bridge.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/22.
 */
public abstract class HandsetBrand {
    protected static final Logger logger = Logger.getLogger(HandsetBrand.class);
    protected HandsetSoft handsetSoft;
    public void setHandsetSoft(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }
    public abstract void run();
}
