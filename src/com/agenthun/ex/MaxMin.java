package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/7/28.
 */
public class MaxMin {
    public static int max(int a, int b) {
        return (a + b + Math.abs(a - b)) / 2;
    }

    public static int min(int a, int b) {
        return (a + b - Math.abs(a - b)) / 2;
    }

    public static void main(String[] args) {
        System.out.println("max(3,5) = " + max(3, 5));
        System.out.println("min(3,5) = " + min(3, 5));
    }
}
