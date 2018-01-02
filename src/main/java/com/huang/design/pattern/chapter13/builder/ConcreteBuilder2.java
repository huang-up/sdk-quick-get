package com.huang.design.pattern.chapter13.builder;

/**
 * Created by h on 2017/9/29.
 */
public class ConcreteBuilder2 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}