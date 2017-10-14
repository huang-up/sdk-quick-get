package design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class NoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            super.logger.info(String.format("当前时间：%s点 饿了，午饭；犯困，午休", work.getHour()));
        } else {
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}
