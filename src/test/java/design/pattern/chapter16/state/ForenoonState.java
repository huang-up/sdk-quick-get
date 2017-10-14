package design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class ForenoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            super.logger.info(String.format("当前时间：%s点 上午工作，精神百倍", work.getHour()));
        } else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
