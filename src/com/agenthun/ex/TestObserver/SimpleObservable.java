package com.agenthun.ex.TestObserver;

import java.util.Observable;

/**
 * Created by agenthun on 16/3/6.
 */
public class SimpleObservable extends Observable {
    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        if (this.data != i) {
            this.data = i;
            setChanged();
            notifyObservers();
        }
    }
}
