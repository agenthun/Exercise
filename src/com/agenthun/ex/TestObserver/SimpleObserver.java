package com.agenthun.ex.TestObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by agenthun on 16/3/6.
 */
public class SimpleObserver implements Observer {
    public SimpleObserver(SimpleObservable simpleObservable) {
        simpleObservable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("SimpleObserver: getData " + ((SimpleObservable) o).getData());
    }
}
