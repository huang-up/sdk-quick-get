package generic;

import generic.array.Shape;

import java.util.Collection;

/**
 * 泛型（泛型集合）不是协变的，会产生编译器错误，而不是类型不匹配的运行时异常。
 * 若无附加的语法，则用户就会避免使用集合（Collection），因为失去协变性使得代码缺少灵活性。
 * Java5使用通配符（wildcard）来弥补这个不足。通配符用来表示参数类型的子类（或超类）。
 * Created by h on 2017/11/2.
 */
public class WildcardGeneric {

    // 通配符用来表示参数类型
    public static float totalLength(Collection<? extends Shape> arr) {
        float total = 0f;
        for (Shape s:arr) {
            if (s != null) {
                total += s.getRadius();
            }
        }
        return total;
    }

    /*
     * 从某种意义上说，上面的totalLength方法是泛型方法，因为它能够接受不同类型的参数。
     * 但是，这里没有特定类型的参数表，正如GenericClass类的声明中所做的那样。
     * 有时候特定类型很重要，这或许因为下列的原因：
     * 1. 该特定类型用做返回类型
     * 2. 该类型用在多于一个的参数类型中
     * 3. 该类型用于声明一个局部变量
     * 如果是这样，那么，必须要声明一种带有若干类型参数的显示泛型方法。
     */


    // 泛型方法
    // 泛型方法特别像泛型类，因为类型参数表使用相同的语法。在泛型方法中的类型参数位于返回类型之前。
    public static <AnyType> boolean contains(AnyType[] arr, AnyType x) {
        boolean result = false;
        for (AnyType val:arr) {
            if (x.equals(val)) {
                result = true;
            }
        }
        return result;
    }

    // 类型参数的限界
    //  <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”，不能往里存，只能往外取
    //  <? super T>：是指 “下界通配符（Lower Bounds Wildcards）”，不影响往里存，但往外取只能放在Object对象里
//    最后看一下什么是PECS（Producer Extends Consumer Super）原则，已经很好理解了：
//    1. 频繁往外读取内容的，适合用上界Extends。
//    2. 经常往里插入的，适合用下界Super。
    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
