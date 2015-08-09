package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/9.
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread begin");
                    Thread.sleep(5000);
                    System.out.println("thread end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            thread.join(1000);
            System.out.println("join() begin");
            if (thread.isAlive()) System.out.println("thread has not finished");
            else System.out.println("thread has finished");
            System.out.println("join() end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
