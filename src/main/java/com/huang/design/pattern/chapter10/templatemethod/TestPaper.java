package com.huang.design.pattern.chapter10.templatemethod;

import org.apache.log4j.Logger;

/**
 * 试题
 * Created by admin on 2017/9/25.
 */
public abstract class TestPaper {
    private static final Logger logger = Logger.getLogger(TestPaper.class);

    public void testQuesttion1() {
        logger.info("question1");
        logger.info(answer1());
    }

    public void testQuesttion2() {
        logger.info("question2");
        logger.info(answer2());
    }

    public void testQuesttion3() {
        logger.info("question3");
        logger.info(answer3());
    }

    abstract String answer1();

    abstract String answer2();

    abstract String answer3();
}
