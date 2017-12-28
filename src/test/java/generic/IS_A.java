package generic;

/**
 * IS-A:技术术语是否拥有协变性
 * java中的数组是协变的，数组的协变性导致下面的异常 java.lang.ArrayStoreException
 * Created by h on 2017/11/2.
 */
public class IS_A {
    /*
    * 假设 Employee IS-A Person，那么是不是意味着 Employee[] IS-A Person[]，换句话说，如果一个例程接受 Person[] 作为参数，
    * 那么我们能不能把 Employee[] 作为参数来传递呢？
    *
    * 假设除 Employee[] 之外，我们还有 Student IS-A Person，并设 Employee[] 类型是和 Person[] 类型兼容的。
    * 此时考虑下面两句赋值语句：
    * Person[] arr = new Person[5];
    * arr[0] = new Student(...);    // java.lang.ArrayStoreException
    *
    * */


    /**
     * 类型擦除
     * 泛型在很大程度上是Java语言中的成分而不是虚拟机中的结构。
     * 1、泛型类可以由编译器通过所谓的类型擦除（type erasure）过程而转变成非泛型类。
     * 这样，编译器就生成一种与泛型同名的原始类（raw class），但是类型参数都被删去了。
     * 2、类型变量由它们的类型限界来代替，当一个具有擦除返回类型的泛型方法被调用的时候，一些特性被自动地插入。
     * 如果使用一个泛型类而不带类型参数，那么使用的是原始类。
     *
     * 类型擦除的一个重要推论是，所生成的代码与程序员在泛型之前所写的代码并没有太多的差异，而且事实上运行的也不快。
     * 其显著的优点在于，程序员不必把一些类型转换放到代码中，编译器将进行重要的类型检验。
     */

    /**
     * 对于泛型的限制
     * 对于泛型类型有许多的限制。由于类型擦除的原因，这里列出的每一个限制都是必须遵守的。
     * 1、基本类型
     * 基本类型不能用作类型参数。因此，GenericClass<int>是非法的，我们必须使用包装类。
     * 2、instanceof检测
     * instanceof检测和类型转换工作只对原始类型进行。在下列代码中
     * GenericClass<Integer> cell1 = new GenericClass<Integer>();
     * cell.write(4);
     * Object cell = cell1;
     * GenericClass<String> cell2 = (GenericClass<String>) cell;
     * String s = cell2.read();
     * 这里的类型转换在运行时是成功的，因为所有的类型都是GenericClass。
     * 但在最后一行，由于对read的调用企图返回一个String对象从而产生一个运行时错误。
     * 结果，类型转换将产生一个警告，而对应的instanceof检测是非法的。
     * 3、static的语境
     * 在一个泛型类中，static方法和static域均不可引用类的类型变量，因为在类型擦除后类型变量就不存在了。
     * 另外，由于实际上只存在一个原始的类，因此static域在该类的诸泛型实例之间是共享的。
     * 4、泛型类型的实例化
     * 不能创建一个泛型类型的实例。如果T是一个类型变量，则语句是非法的。
     * T由它的限界代替，这可能是Object(或甚至是抽象类)，因此对new的调用没有意义。
     * T obj = new T(); // 右边是非法的
     * 5、泛型数组对象
     * 也不能创建一个泛型的数组。如果T是一个类型变量，则语句是非法的。
     * T[] arr = new T[10];
     * T将由它的限界代替，这很可能是Object T，于是（由类型擦除产生的）对T[]的类型转换将无法进行，
     * 因为Object[] IS-NOT-A T[] 。由于我们不能创建泛型对象的数组，因此一般说来我们必须创建一个擦除类型的数组，然后使用类型转换。
     * 这种类型转换将产生一个关于未检验的类型转换的编译警告。
     * 5、参数化类型的数组
     * 参数化类型的数组的实例化是非法的。考虑下列代码：
     * GenericClass<String>[] arr1 = new GenericClass<String>[10];
     * GenericClass<Double> cell = new GenericClass<Double>(); cell.write(4.5)
     * Object[] arr2 = arr1;
     * arr2[0] = cell;
     * String s = arr1[0].read();
     * 正常情况下，我们认为第四行的赋值会产生一个ArrayStoreException，因为赋值的类型有错误。
     * 可是，在类型擦除之后，数组的类型为GenericClass[]，而加到数组中的对象也是GenericClass，因此不存在ArrayStoreException异常。
     * 于是，该段代码没有类型转换，它最终将在第5行产生一个ClassCastException异常，这正是泛型应该避免的情况。
     *
     */
}
