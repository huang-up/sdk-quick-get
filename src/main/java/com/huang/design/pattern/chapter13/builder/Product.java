package com.huang.design.pattern.chapter13.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by h on 2017/9/29.
 */
public class Product {
    private static final Logger logger = LoggerFactory.getLogger(Product.class);
    private List<String> parts = new ArrayList<String>();
    public void add(String part) {
        parts.add(part);
    }
    public void show() {
        for (String part:parts) {
            logger.info(part);
        }
    }
}
