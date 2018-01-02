package com.huang.es.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huang.es.ESNodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/1/2.
 */
@RestController
public class LogController {

    @Autowired
    private ESNodeService esNodeService;

    @PostMapping(value = "_bulk")
    public void log(@RequestBody String content) {
        String[] lines = StringUtils.split(content, "\n");
        JSONObject[] jsonObjects = new JSONObject[lines.length];
        for (int i = 0; i < lines.length; i++) {
            jsonObjects[i] = JSON.parseObject(lines[i]);
        }
        esNodeService.store(jsonObjects);
    }
}
