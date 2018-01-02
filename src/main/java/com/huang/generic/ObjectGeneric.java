package com.huang.generic;

/**
 * 在java5之前，使用Object表示泛型
 * 重要的细节是不能使用基本类型。只有引用类型才能够和Object兼容。
 * Created by h on 2017/11/2.
 */
public class ObjectGeneric {
    private Object storedValue;
    public Object read() {
        return this.storedValue;
    }
    public void write(Object o) {
        this.storedValue = o;
    }
    public static void main(String[] args) {
        ObjectGeneric mc = new ObjectGeneric();
        mc.write("37");
        String value = (String) mc.read();
        System.out.println("Content are: " + value);
    }
}
