package com.agenthun.ex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Agent Henry on 2015/8/9.
 */
public class SynchronizedAndLockTest {
    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    syncTest.addValueSync();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    syncTest.addValueLock();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

class SyncTest {
    private int value = 0;
    Lock lock = new ReentrantLock();

    public synchronized void addValueSync() {
        this.value++;
        System.out.println(Thread.currentThread().getName() + " : " + value);
    }

    public void addValueLock() {
        try {
            lock.lock();
            value++;
            System.out.println(Thread.currentThread().getName() + " : " + value);
        } finally {
            lock.unlock();
        }
    }

}
