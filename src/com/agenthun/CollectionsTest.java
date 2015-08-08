package com.agenthun;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Agent Henry on 2015/8/8.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int[] array = {1, 7, 3, 2};
        for (int i = 0; i < array.length; i++) {
            list.add(new Integer(array[i]));
        }

        Collections.sort(list);
        for (int i = 0; i < array.length; i++) {
            System.out.println(list.get(i));
        }
    }
}
