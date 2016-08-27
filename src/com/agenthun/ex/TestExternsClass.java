package com.agenthun.ex;

/**
 * Created by agenthun on 16/8/28.
 * 类继承加载顺序:
 * 父类static属性、代码块
 * 子类static属性、代码块
 * 父类非static属性、代码块、构造函数
 * 子类非static属性、代码块、构造函数
 */
class X {
    Y y = new Y();

    public X() {
        System.out.print("X");
    }
}

class Y {
    public Y() {
        System.out.print("Y");
    }
}

public class TestExternsClass extends X {
    Y y = new Y();

    public TestExternsClass() {
        System.out.print("Z");
    }

    public static void main(String[] args) {
        new TestExternsClass();
    }
}
