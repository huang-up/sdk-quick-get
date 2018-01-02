package com.huang.design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class SleepingState extends State {
    @Override
    public void writeProgram(Work work) {
        super.logger.info(String.format("当前时间：%s点 不行了，睡着了", work.getHour()));
    }
}
