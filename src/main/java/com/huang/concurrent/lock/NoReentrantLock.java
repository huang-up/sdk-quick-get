package com.huang.concurrent.lock;

/**
 * Created by h on 2018/4/22.
 */
public class NoReentrantLock implements ILock {
    private boolean isLocked;
    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notifyAll();
    }
}
