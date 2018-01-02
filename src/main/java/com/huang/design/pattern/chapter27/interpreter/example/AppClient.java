package com.huang.design.pattern.chapter27.interpreter.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/28.
 */
public class AppClient {
    private static final Logger logegr = Logger.getLogger(AppClient.class);
    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        context.setText("T 500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");
        Expression expression = null;
        try {
            while (context.getText().length() > 0) {
                String str = context.getText().substring(0,1);
                switch (str) {
                    case "O":
                        expression = new Scale();
                        break;
                    case "T":
                        expression = new Speed();
                        break;
                    case "C":
                    case "D":
                    case "E":
                    case "F":
                    case "G":
                    case "A":
                    case "B":
                    case "P":
                        expression = new Note();
                        break;
                }
                expression.interpret(context);
            }
        } catch (Exception e) {
            logegr.error(e.getMessage());
        }
    }
}
