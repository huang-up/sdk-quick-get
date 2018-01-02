package com.huang.generic.array;

/**
 * 使用接口类型表示泛型
 * Created by h on 2017/11/2.
 */
public class ArrayType {

    public static Comparable findMax(Comparable[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        ArrayType ad = new ArrayType();
        Shape[] sh1 = new Shape[]{new Circle(1.0f), new Square(3.0f), new Rectangle(2.0f)};
        String[] st1 = new String[]{"Bob", "Joe", "Bill", "Jack"};
        System.out.println(findMax(sh1));
        System.out.println(findMax(st1));
    }

}
