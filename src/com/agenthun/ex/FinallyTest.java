package com.agenthun.ex;

/**
 * Created by Agent Henry on 2015/8/4.
 */
public class FinallyTest {
    public static int finallyTest() {
        try {
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("execute finally");
            return 3; //注意finally在最前面执行
        }
    }

    public static void main(String[] args) {
        int result = finallyTest();
        System.out.println(result);
    }
}
