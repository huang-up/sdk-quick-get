package com.huang.generic;

import com.huang.generic.array.Shape;

/**
 * Created by h on 2017/11/2.
 */

public interface GenericInterface {
    /**
     * 泛型方法
     */
    <AnyType> int compareTo(AnyType anyType);
}

/**
 * 泛型接口
 */
interface Generic<AnyType> {
    int compareTo(AnyType anyType);
}
