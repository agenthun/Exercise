package com.agenthun;

import java.util.ArrayList;

/**
 * Created by Agent Henry on 2015/8/6.
 */
public class Prime {
    public static void main(String[] args) {
        int[] primes = Prime.findPrimes(1000);
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i] + " ");
        }
        System.out.println();
    }

    public static int[] findPrimes(int max) {
        int[] prime = new int[max + 1];
        ArrayList list = new ArrayList();

        for (int i = 2; i <= max; i++) {
            prime[i] = 1;
        }
        for (int i = 2; i * i <= max; i++) {
            if (prime[i] == 1) {
                for (int j = 2 * i; j <= max; j++) {
                    if (j % i == 0) prime[j] = 0;
                }
            }
        }
        for (int i = 2; i < max; i++) {
            if (prime[i] == 1) list.add(new Integer(i));
        }

        int[] p = new int[list.size()];
        Object[] objs = list.toArray();
        for (int i = 0; i < p.length; i++) {
            p[i] = ((Integer) objs[i]).intValue();
        }
        return p;
    }
}
