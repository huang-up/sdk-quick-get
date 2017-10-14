package design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class ForceLeaveState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() > 20) {
            super.logger.info(String.format("当前时间：%s点 强制下班，回家了", work.getHour()));
        } else {
            super.logger.info(String.format("当前时间：%s点 要加班，加班呢", work.getHour()));
        }
    }
}
