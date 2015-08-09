package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/9.
 */
public class ThreadStopTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread go to sleep");
                try {
                    Thread.sleep(5000);
                    System.out.println("thread finish");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted");
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
}
