package com.huang.generic;

/**
 * 自动装箱和拆箱
 * Created by h on 2017/11/2.
 */
public class Boxing {
    public static void main(String[] args) {
        GenericClass<Integer> m = new GenericClass<Integer>();
        m.write(37); // 自动装箱
        int value = m.read(); // 自动拆箱
        System.out.println(value);
    }
}
