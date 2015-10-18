package com.agenthun.ex;

/**
 * Created by agenthun on 15/10/18.
 */
public class TestExtends {
    public static void main(String[] args) {
        System.out.println("create AA");
        A a = new A();

        System.out.println("create AB");
        A b = new B();

        System.out.println("create AC");
        A c = new C();
    }
}

class A {
    {
        System.out.println("A 代码块");
    }

    A() {
        System.out.println("A");
    }
}

class B extends A {
    {
        System.out.println("B 代码块");
    }

    B() {
        System.out.println("B");
    }
}

class C extends B {
    {
        System.out.println("C 代码块");
    }

    C() {
        System.out.println("C");
    }
}
