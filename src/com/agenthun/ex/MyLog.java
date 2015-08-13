package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/14.
 */
public class MyLog {
    public static double myLog(double a) {
        int N = 15;
        int k, nk;
        double x, xx, y;
        x = (a - 1) / (a + 1);
        xx = x * x;
        nk = 2 * N + 1;
        y = 1.0 / nk;
        for (k = N; k > 0; k--) {
            nk -= 2;
            y = 1.0 / nk + xx * y;
        }
        return 2.0 * x * y;
    }

    public static void main(String[] args) {
        double x = 2.0;
        System.out.println("ln(" + x + ") = " + myLog(2));
    }
}
