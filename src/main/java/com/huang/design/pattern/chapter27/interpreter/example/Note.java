package com.huang.design.pattern.chapter27.interpreter.example;

/**
 * Created by h on 2017/10/28.
 */
public class Note extends Expression {
    @Override
    public void execute(String playKey, double playValue) {
        String note = "";
        switch (playKey) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
        }
        super.logger.info(note);
    }
}
