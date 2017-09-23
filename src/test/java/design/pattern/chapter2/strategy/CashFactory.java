package design.pattern.chapter2.strategy;

/**
 * Created by h on 2017/9/23.
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type) {
        CashSuper cashSuper = null;
        switch (type) {
            case "满300减100":
                cashSuper = new CashReturn("300", "100");
                break;
            case "打8折":
                cashSuper = new CashRebate("0.8");
                break;
            case "正常收费":
            default:
                cashSuper = new CashNormal();
                break;
        }
        return cashSuper;
    }
}
