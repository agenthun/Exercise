package com.agenthun;

/**
 * Created by Agent Henry on 2015/8/3.
 */
public class Singleton {
    private static Singleton instance = null;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
