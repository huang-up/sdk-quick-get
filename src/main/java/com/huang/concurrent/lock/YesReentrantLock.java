package com.huang.concurrent.lock;

/**
 * Created by h on 2018/4/22.
 */
public class YesReentrantLock implements ILock{
    private boolean isLocked;
    private Thread lockByThread;
    private int lockCount;
    public synchronized void lock() {
        while (isLocked && (lockByThread != Thread.currentThread())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockCount++;
        lockByThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (lockByThread == Thread.currentThread()) {
            if (--lockCount == 0) {
                isLocked = false;
                notifyAll();
            }
        }
    }
}
