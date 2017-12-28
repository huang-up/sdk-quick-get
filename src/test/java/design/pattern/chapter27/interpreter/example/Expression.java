package design.pattern.chapter27.interpreter.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/28.
 */
public abstract class Expression {
    protected static final Logger logger = Logger.getLogger(Expression.class);
    public void interpret(PlayContext context) {
        if (context.getText().length() == 0) {
            return;
        } else {
            String playKey = context.getText().substring(0,1);
            context.setText(context.getText().substring(2));
            double playValue = Double.parseDouble(context.getText().substring(0, context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
            execute(playKey, playValue);
        }
    }

    public abstract void execute(String playKey, double playValue);
}
