package com.huang.design.pattern.chapter21.sigleton;

/**
 * Created by admin on 2018/1/3.
 */
// 单实例的枚举类是实现单例的最佳实践
public enum BestEnum {
    INSTANCE;
    // 需要单实例的资源
    private Resource resource;
    private BestEnum() {
        resource = new Resource();
    }
    public Resource getInstance() {
        return resource;
    }
}
