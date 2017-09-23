package design.pattern.chapter2.strategy;

/**
 * 策略模式和简单工厂模式的结合
 *
 * Created by h on 2017/9/23.
 */
public class CashContext {
    private CashSuper cashSuper;
    private CashContext() {}
    public CashContext(String type) {
        switch (type) {
            case "满300减100":
                this.cashSuper = new CashReturn("300", "100");
                break;
            case "打8折":
                this.cashSuper = new CashRebate("0.8");
                break;
            case "正常收费":
            default:
                this.cashSuper = new CashNormal();
                break;
        }
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
