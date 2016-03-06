package com.agenthun.ex.TestObserver;

/**
 * Created by agenthun on 16/3/6.
 */
public class TestSimpleObserver {
    public static void main(String[] args) {
        SimpleObservable simpleObservable = new SimpleObservable();
        SimpleObserver simpleObserver = new SimpleObserver(simpleObservable);
        simpleObservable.setData(1);
        simpleObservable.setData(2);
        simpleObservable.setData(3);
        simpleObservable.setData(4);
    }
}
