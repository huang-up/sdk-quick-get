package com.huang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/1/2.
 */
@RestController
public class TestController {

    /*@Value("${spring}")
    private String name;*/

    @GetMapping(value = "/name")
    public String name() {
//        return this.name;
        return "Hello World!";
    }
}
