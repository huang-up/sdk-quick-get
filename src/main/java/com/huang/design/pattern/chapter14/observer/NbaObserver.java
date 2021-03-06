package com.huang.design.pattern.chapter14.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/8.
 */
public class NbaObserver implements Observer {
    private String name;
    private Subject subject;
    private static final Logger logger = LoggerFactory.getLogger(NbaObserver.class);
    public NbaObserver() {}
    public NbaObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }
    @Override
    public void update() {
        logger.info(String.format("%s %s 关闭NBA直播，继续工作！", subject.getSubjectState(), name));
    }
}
