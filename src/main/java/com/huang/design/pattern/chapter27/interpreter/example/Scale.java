package com.huang.design.pattern.chapter27.interpreter.example;

/**
 * Created by h on 2017/10/28.
 */
public class Scale extends Expression {
    @Override
    public void execute(String playKey, double playValue) {
        String scale = "";
        switch (playValue+"") {
            case "1.0":
                scale = "低音";
                break;
            case "2.0":
                scale = "中音";
                break;
            case "3.0":
                scale = "高音";
                break;
        }
        super.logger.info(scale);
    }
}
