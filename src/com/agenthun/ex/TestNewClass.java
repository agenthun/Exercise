package com.agenthun.ex;

/**
 * Created by agenthun on 16/8/28.
 * 主要结果:
 * 定义类中有public变量,有public方法对其修改,在main方法中new这个类,调用public方法。并不改变这个public变量
 * 若是private变量, 则有改变这个变量
 * public的变量, 输出结果都为"6"
 * private的变量结果见 TestExternsClass2.class
 */
public class TestNewClass {
    public String str = "6";
    public StringBuilder sb = new StringBuilder("6");

    public static void main(String[] args) {
        TestNewClass sv = new TestNewClass();
        sv.change(sv.str);
        sv.change(sv.sb);
        System.out.println(sv.str);
        System.out.println(sv.sb);
    }

    public void change(String str) {
        str = "10";
    }

    public void change(StringBuilder str) {
        str = new StringBuilder("10");
    }
}
