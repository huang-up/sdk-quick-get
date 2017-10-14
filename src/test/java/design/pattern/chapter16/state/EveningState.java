package design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class EveningState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.isTaskFinished()) {
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                super.logger.info(String.format("当前时间：%s点 加班哦，疲累之极", work.getHour()));
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
