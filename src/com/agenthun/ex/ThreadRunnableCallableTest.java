package com.agenthun.ex;

import java.util.concurrent.*;

/**
 * Created by Agent Henry on 2015/8/9.
 */
public class ThreadRunnableCallableTest {
    public static void main(String[] args) {
        System.out.println("this is Thread test");
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("this is Runnable test");
        MyRunnable myRunnable = new MyRunnable();
        Thread threadRunnable = new Thread(myRunnable);
        threadRunnable.start();

        System.out.println("this is Callable test");
        MyCallable myCallable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(myCallable);
        try {
            System.out.println("waiting Callable thread to finish");
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("this is Thread run()");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("this is Runnable run()");
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return "this is Callable call()";
    }
}
