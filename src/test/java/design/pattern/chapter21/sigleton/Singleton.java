package design.pattern.chapter21.sigleton;

/**
 * 多线程时的单例
 * Created by h on 2017/10/20.
 */
public class Singleton {
    private static Singleton instance;
//    静态初始化
//    private static final Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
//        return instance;
    }
}