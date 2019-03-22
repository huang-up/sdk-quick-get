package com.huang.generic;

/**
 * 基本类型的包装类。
 * Created by h on 2017/11/2.
 */

public class WrapperObjectGeneric {
    public static void main(String[] args) {
        ObjectGeneric mc = new ObjectGeneric();
        mc.write(new Integer(37));
        Integer wrapperValue = (Integer) mc.read();
        int value = wrapperValue.intValue();
        System.out.println("Content are: " + value);
    }
}
