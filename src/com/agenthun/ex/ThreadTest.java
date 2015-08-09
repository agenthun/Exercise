package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/3.
 */
public class ThreadTest {
    private int j;

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Inc inc = threadTest.new Inc();
        Dec dec = threadTest.new Dec();

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();

            t = new Thread(dec);
            t.start();
        }
    }

    //同步加1
    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "inc: " + j);
    }

    //同步减1
    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "dec: " + j);
    }

    //内部类,多线程:实现runnable接口
    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
