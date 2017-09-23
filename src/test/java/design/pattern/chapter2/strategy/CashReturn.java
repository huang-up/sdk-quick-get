package design.pattern.chapter2.strategy;

/**
 * Created by h on 2017/9/23.
 */
public class CashReturn extends CashSuper {
    private double moneyCondition;
    private double moneyReturn;
    private CashReturn() {}
    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }
    @Override
    double acceptCash(double money) {
        double result = money;
        if (money > moneyCondition) {
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
