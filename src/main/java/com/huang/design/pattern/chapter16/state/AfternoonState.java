package com.huang.design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class AfternoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17) {
            super.logger.info(String.format("当前时间：%s点 下午状态还不错，继续努力", work.getHour()));
        } else {
//            work.setState(new EveningState());
            if (work.isTaskFinished()) {
                work.setState(new RestState());
                work.writeProgram();
            } else {
                work.setState(new ForceLeaveState());
                work.writeProgram();
            }
        }
    }
}
