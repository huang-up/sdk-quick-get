package design.pattern.chapter7.proxy;

/**
 * Created by h on 2017/9/19.
 */
public class AppClient {
    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl("李娇娇");
        Proxy proxy = new Proxy(schoolGirl);

        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();

    }
}
