package design.pattern.chapter2.strategy;

/**
 * 策略模式
 * 实例化哪种策略还需要客户端来做判断做选择
 *
 * Created by h on 2017/9/23.
 */
public class _CashContext {
    private CashSuper cashSuper;
    private _CashContext() {}
    public _CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }
    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
