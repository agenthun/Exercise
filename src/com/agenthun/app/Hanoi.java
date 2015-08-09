package com.agenthun.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Agent Henry on 2015/8/5.
 */
public class Hanoi {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入盘数: ");
        n = Integer.parseInt(buf.readLine());
        Hanoi hanoi = new Hanoi();
        hanoi.move(n, 'A', 'B', 'C');
    }

    public void move(int n, char a, char b, char c) {
        if (n == 1) System.out.println("盘 " + n + "由" + a + "移至" + c);
        else {
            move(n - 1, a, c, b);
            System.out.println("盘 " + n + "由" + a + "移至" + c);
            move(n - 1, b, a, c);
        }
    }
}
