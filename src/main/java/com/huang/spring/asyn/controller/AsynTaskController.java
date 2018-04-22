package com.huang.spring.asyn.controller;

import com.huang.spring.asyn.service.AsynService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by h on 2018/4/7.
 */
@Slf4j
@Controller // 使用模版视图技术时，不能用 @RestController
@RequestMapping("/asyn")
public class AsynTaskController {

    @Autowired
    private AsynService asynService;

    @GetMapping("/task")
    public String asynGet(ModelMap modelMap) {
        long start = System.currentTimeMillis();
        log.info("start process");
        asynService.asynMethod();
        long end = System.currentTimeMillis();
        log.info("complete process use {} ms", end-start);
        modelMap.put("a", "test model without view !");
        modelMap.put("b", "bb!");
        return "index";
    }


    @GetMapping("/index")
    public String index(ModelMap modelMap) {
//        modelMap.put("a", "test model without view !");
        return "index";
    }

    @GetMapping("/forward")
    public String forward(ModelMap modelMap) {
        modelMap.put("a", "test model without view !");
        return "forward:/asyn/index";
    }

    @GetMapping("/redirect")
    public String redirect(ModelMap modelMap) {
        modelMap.put("a", "test model without view !");
        return "redirect:/asyn/index";
    }
}
