package design.pattern.chapter6.decoration;

/**
 * Created by admin on 2017/9/19.
 */
public class AppClient {
    public static void main(String[] args) {
        Person person = new Person("小菜");
        TShirts tShirts = new TShirts();
        tShirts.decorate(person);
        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.decorate(tShirts);
        bigTrouser.show();
    }
}
