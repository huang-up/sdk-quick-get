package generic.array;

import generic.GenericClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by h on 2017/11/2.
 */
public class App {
    public static void test(Person[] arr) {
        arr[0].run();
    }
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person[] arr = new Employee[2];
        arr[0] = new Employee();
//        arr[0] = new Student();   java.lang.ArrayStoreException
        test(arr);

        GenericClass<Student> s = new GenericClass<Student>();
        s.write(new Student());
//        GenericClass<? extends Person> gc = s;
//        gc.read().run();
        GenericClass<?> gc = s;
        Class p = gc.read().getClass();
        Method[] ms = p.getDeclaredMethods();
        Method method = null;
        for (Method m:ms) {
            if (m.getName().equals("run")) {
                method = m;
                break;
            }
        }
        method.invoke(gc.read());
    }
}
