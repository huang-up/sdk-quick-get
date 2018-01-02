package com.huang.design.pattern.chapter10.templatemethod;

/**
 * 学生B抄的试题
 * Created by admin on 2017/9/25.
 */
public class TestPaperB extends TestPaper {
    @Override
    public String answer1() {
        return "B answer1";
    }

    @Override
    public String answer2() {
        return "B answer2";
    }

    @Override
    public String answer3() {
        return "B answer3";
    }
}
