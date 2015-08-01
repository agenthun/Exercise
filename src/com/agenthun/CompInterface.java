package com.agenthun;

/**
 * Created by Agent Henry on 2015/8/1.
 */
public class CompInterface {
    public static void insertSort(int[] a, IntCompare compare) {
        if (a == null || a.length <= 0) return;
        for (int i = 1; i < a.length; i++) {
            if (compare.cmp(a[i], a[i - 1]) == 1) {
                int j = i;
                int temp = a[i];
                while (j > 0 && compare.cmp(temp, a[j - 1]) == 1) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 3, 19, 40, 4, 7, 1};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();

        System.out.println("升序: ");
        insertSort(a, new Cmp1());
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();

        System.out.println("降序: ");
        insertSort(a, new Cmp2());
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}

interface IntCompare {
    public int cmp(int a, int b);
}

class Cmp1 implements IntCompare {

    @Override
    public int cmp(int a, int b) {
        if (a > b) return -1;
        else if (a < b) return 1;
        else
            return 0;
    }
}

class Cmp2 implements IntCompare {

    @Override
    public int cmp(int a, int b) {
        if (a > b) return 1;
        else if (a < b) return -1;
        else
            return 0;
    }
}
