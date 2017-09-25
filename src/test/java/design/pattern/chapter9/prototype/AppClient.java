package design.pattern.chapter9.prototype;

/**
 * 原型模式：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 其实就是从一个对象再创建另外一个可定制的对象，而且不需要知道任何创建对象的细节。
 *
 * 浅复制：被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用都仍然指向原来的对象。
 * 深复制：把引用对象的变量指向复制过的新对象，而不是原有的被引用的对象。
 * 深复制要深入到多少层，需要事先就考虑好，而且要当心循环引用的问题。这里比较复杂，可以慢慢研究。
 * 就现在这个例子，问题应该不大，深入到第一层就可以了。
 *
 * Created by h on 2017/9/24.
 */
public class AppClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume = new Resume("大鸟");
        resume.setPersonInfo("男", 29);
        resume.setWorkExperience("2009-2013", "zz企业");

        Resume resume1 = (Resume) resume.clone();
        resume1.setPersonInfo("男", 20);
        resume1.setWorkExperience("2007-2009", "xx企业");

        resume.display();
        resume1.display();
    }
}
