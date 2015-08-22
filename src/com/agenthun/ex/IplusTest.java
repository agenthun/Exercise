package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/22.
 */
public class IplusTest {
    public static void main(String[] args) {
        int i = 0;
        i = i++;
        System.out.println("i = i++");
        System.out.println("i = " + i);

        i = 0;
        i = ++i;
        System.out.println("i = ++i");
        System.out.println("i = " + i);
    }
}
