package com.huang.es.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by h on 2018/4/5.
 */
public class LogControllerTest {
    private RestTemplate restTemplate;
    @Before
    public void getRestTemplate() {
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Arrays.asList(new FastJsonHttpMessageConverter()));
    }

    @Test
    public void t1() {
        Map map = new HashMap();
        map.put("app", "test");
        map.put("d", "2018-04-05T20:16:00.000");
        Map message = new HashMap();
        message.put("a", "aa");
        message.put("b", "bb");
        message.put("c", "cc");
        message.put("d", "dd");
        map.put("m", message);
        LinkedMultiValueMap<String, String> lmm = new LinkedMultiValueMap<String, String>();
        lmm.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        HttpEntity httpEntity = new HttpEntity(JSON.toJSONString(map), lmm);
        restTemplate.postForObject("http://localhost:8080/_bulk", httpEntity, Void.class);
    }

}
