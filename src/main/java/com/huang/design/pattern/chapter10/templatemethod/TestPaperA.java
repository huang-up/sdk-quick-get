package com.huang.design.pattern.chapter10.templatemethod;

/**
 * 学生A抄的试题
 * Created by admin on 2017/9/25.
 */
public class TestPaperA extends TestPaper {
    @Override
    public String answer1() {
        return "A answer1";
    }

    @Override
    public String answer2() {
        return "A answer2";
    }

    @Override
    public String answer3() {
        return "A answer3";
    }
}
