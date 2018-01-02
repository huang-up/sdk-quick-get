package com.huang.design.pattern.chapter22.bridge.example;

/**
 * Created by h on 2017/10/22.
 */
public class AppClient {
    public static void main(String[] args) {
        HandsetBrand hb = new HandsetBrandM();
        hb.setHandsetSoft(new HandsetGame());
        hb.run();

        hb.setHandsetSoft(new HandsetAddressList());
        hb.run();

        hb = new HandsetBrandN();
        hb.setHandsetSoft(new HandsetGame());
        hb.run();

        hb.setHandsetSoft(new HandsetAddressList());
        hb.run();
    }
}
