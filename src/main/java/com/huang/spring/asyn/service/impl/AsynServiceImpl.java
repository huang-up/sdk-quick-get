package com.huang.spring.asyn.service.impl;

import com.huang.spring.asyn.service.AsynService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by h on 2018/4/7.
 */
@Slf4j
@Service("asynService")
public class AsynServiceImpl implements AsynService {
    @Async
    @Override
    public void asynMethod() {
        try {
            Thread.sleep(3000);
            log.info("async mehtod finished");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
