package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/9.
 */
public class ThreadDaemonTest {
    public static void main(String[] args) {
        System.out.println("test begin");
        MyThreadx t1 = new MyThreadx();
        t1.setDaemon(true);
        t1.start();
        System.out.println("test end");
    }
}

class MyThreadx extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " :end");
    }
}
