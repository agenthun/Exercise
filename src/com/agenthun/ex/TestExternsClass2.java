package com.agenthun.ex;

/**
 * Created by agenthun on 16/8/28.
 * 主要结果:
 * 定义类中有public变量,有public方法对其修改,在main方法中new这个类,调用public方法。并不改变这个public变量
 * 若是private变量, 则有改变这个变量
 * public的变量, 输出结果都为"6"
 * private的变量结果见 TestExternsClass2.class
 */
public class TestExternsClass2 {
    private int count;

    public static void main(String[] args) {
        TestExternsClass2 test = new TestExternsClass2(88);
        System.out.println(test.count);
        test.change(6);
        System.out.println(test.count);
    }

    TestExternsClass2(int a) {
        count = a;
    }

    public void change(int x) {
        count = x;
    }
}
