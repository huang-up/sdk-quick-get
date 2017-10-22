package design.pattern.chapter21.sigleton;

import org.apache.log4j.Logger;

/**
 * 单例模式：保证一个类只有一个实例，并提供一个访问它的全局访问点。
 *
 * 1、静态初始化方式是在自己被加载时就将自己实例化，所以被形象地称为饿汉式单例类。
 * 2、另一种要在第一次被引用时，才会将自己实例化，所以被称为懒汉式单例类。
 *
 * Created by admin on 2017/10/19.
 */
public class AppClient {
    private static final Logger logger = Logger.getLogger(AppClient.class);
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        if (singleton == singleton) {
            logger.info("两个对象是相同的实例");
        }
    }
}
