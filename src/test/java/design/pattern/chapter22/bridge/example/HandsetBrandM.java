package design.pattern.chapter22.bridge.example;

/**
 * Created by h on 2017/10/22.
 */
public class HandsetBrandM extends HandsetBrand {
    @Override
    public void run() {
        super.handsetSoft.run();
    }
}
