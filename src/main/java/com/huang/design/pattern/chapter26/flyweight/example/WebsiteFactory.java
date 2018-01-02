package com.huang.design.pattern.chapter26.flyweight.example;

import java.util.Hashtable;

/**
 * Created by h on 2017/10/25.
 */
public class WebsiteFactory {
    private Hashtable<String, Website> flyweights = new Hashtable<String, Website>();
    public Website getWebsiteCategory(String key) {
        if (!flyweights.contains(key)) {
            flyweights.put(key, new ConcreteWebsite(key));
        }
        return flyweights.get(key);
    }
    public int getWebsiteCount() {
        return flyweights.size();
    }
}
