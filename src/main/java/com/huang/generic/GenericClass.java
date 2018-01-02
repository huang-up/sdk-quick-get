package com.huang.generic;

/**
 * Created by h on 2017/11/2.
 */
public class GenericClass<AnyType> {
    private AnyType anyType;
    public AnyType read() {
        return anyType;
    }
    public void write(AnyType anyType) {
        this.anyType = anyType;
    }
}
