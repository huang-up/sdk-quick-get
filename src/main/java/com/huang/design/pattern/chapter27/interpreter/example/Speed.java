package com.huang.design.pattern.chapter27.interpreter.example;

/**
 * Created by h on 2017/10/28.
 */
public class Speed extends Expression {
    @Override
    public void execute(String playKey, double playValue) {
        String speed = "";
        if (playValue < 500) {
            speed = "快速";
        } else if (playValue >= 1000) {
            speed = "慢速";
        } else {
            speed = "中速";
        }
        super.logger.info(speed);
    }
}
