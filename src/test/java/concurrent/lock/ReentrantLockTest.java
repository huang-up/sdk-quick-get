package concurrent.lock;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by h on 2017/9/7.
 */
// 一次只有一个线程能获得Lock（和synchronized有相同的语义和行为,但是有扩展的能力，而且需要显示释放Lock),
// 除了ReadWriteLock内的ReadLock可以多线程并发进入
public class ReentrantLockTest extends TestCase {

    private final static Logger LOGGER = Logger.getLogger(ReentrantLockTest.class);

    public void test1() throws InterruptedException {
        final Outputter output = new Outputter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                output.print(" zhangsan ");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                output.print(" lisi ");
            }
        }).start();

        for (; ; ) {
        }
    }

    class Outputter {
        private Lock lock = new ReentrantLock();// 锁对象

        public void print(String name) {
            lock.lock();// 得到锁
            try {
                for (int i = 0; i < name.length(); i++) {
                    Thread.sleep(500);
                    LOGGER.info(Character.toString(name.charAt(i)));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();// 释放锁
            }
        }
    }
}
