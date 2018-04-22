package com.huang.generic.array;

import com.huang.generic.GenericClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by h on 2017/11/2.
 */
public class App {
    public static void test(Person[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].run();
        }
    }
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person[] arr = new Person[2];
        arr[0] = new Employee();
        arr[1] = new Student();   // java.lang.ArrayStoreException
        test(arr);

        GenericClass<Student> s = new GenericClass<Student>();
        s.write(new Student());
        GenericClass<? extends Person> gc = s;
        gc.read().run();
//        GenericClass<?> gc = s;
//        Class p = gc.read().getClass();
//        Method[] ms = p.getDeclaredMethods();
//        Method method = null;
//        for (Method m:ms) {
//            if (m.getName().equals("run")) {
//                method = m;
//                break;
//            }
//        }
//        method.invoke(gc.read());
    }
}
