package design.pattern.chapter25.mediator.example;

/**
 * Created by h on 2017/10/24.
 */
public class AppClient {
    public static void main(String[] args) {
        UnitedNationsSecurityCouncil unsc = new UnitedNationsSecurityCouncil();
        USA c1 = new USA(unsc);
        Iraq c2 = new Iraq(unsc);

        unsc.setColleague1(c1);
        unsc.setColleague2(c2);

        c1.declare("不准研制核武器，否则要发动战争！");
        c2.declare("我们没有核武器，也不怕侵略。");

    }
}
