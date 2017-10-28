package design.pattern.chapter27.interpreter;

/**
 * Created by h on 2017/10/28.
 */
public class NonTerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        super.logger.info("非终端解释器");
    }
}
