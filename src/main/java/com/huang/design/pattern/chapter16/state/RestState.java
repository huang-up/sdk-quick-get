package com.huang.design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class RestState extends State {
    @Override
    public void writeProgram(Work work) {
        super.logger.info(String.format("当前时间：%s点 下班回家了", work.getHour()));
    }
}
