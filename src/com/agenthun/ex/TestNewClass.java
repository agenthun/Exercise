package com.agenthun.ex;

/**
 * Created by agenthun on 16/8/28.
 * 考察重点: 引用传递、值传递
 * 主要结果:
 * 定义类中有public/private对象变量,有public方法对其修改,在main方法中new这个类,调用public方法。并不改变这个public/private对象变量(引用传递)
 * 变量, 输出结果都为"6"
 */
public class TestNewClass {
    public int countPublic;
    private int countPrivate;
    private String strPrivate = "6";
    public String str = "6";
    public StringBuilder sb = new StringBuilder("6");

    public static void main(String[] args) {
        TestNewClass sv = new TestNewClass();
        System.out.println("sv.strPrivate = " + sv.strPrivate);
        System.out.println("sv.str = " + sv.str);
        System.out.println("sv.sb = " + sv.sb);
        System.out.println("sv.countPublic = " + sv.countPublic);
        System.out.println("sv.countPrivate = " + sv.countPrivate);

        sv.change(sv.strPrivate);
        System.out.println(sv.strPrivate);
        sv.change(sv.str);
        System.out.println(sv.str);
        sv.change(sv.sb);
        System.out.println(sv.sb);

        sv.changePublic(6);
        System.out.println(sv.countPublic);
        sv.changePrivate(6);
        System.out.println(sv.countPrivate);
    }

    public void change(String str) {
        str = "10";
    }

    public void change(StringBuilder str) {
        str = new StringBuilder("10");
    }

    public void changePublic(int x) {
        countPublic = x;
    }

    public void changePrivate(int x) {
        countPrivate = x;
    }
}
