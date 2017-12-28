package design.pattern.chapter27.interpreter;

/**
 * Created by h on 2017/10/28.
 */
public class TerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        super.logger.info("终端解释器");
    }
}
