package com.agenthun.ex;

import java.io.*;

/**
 * Created by Agent Henry on 2015/8/24.
 */
public class FileIOTest {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("src/com/agenthun/ex/test.txt"));
        double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
        int[] units = {12, 8, 13, 29, 50};
        String[] descs = {"Java T-Shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain"};
        for (int i = 0; i < prices.length; i++) {
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
            out.writeChars(descs[i]);
            out.writeChar('\n');
        }
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("src/com/agenthun/ex/test.txt"));
        double price;
        int unit;
        StringBuffer desc;
        double total = 0.0;

        try {
            while (true) {
                price = in.readDouble();
                in.readChar();
                unit = in.readInt();
                in.readChar();
                char chr;
                desc = new StringBuffer();
                while ((chr = in.readChar()) != '\n')
                    desc.append(chr);
                System.out.println("unit = " + unit + ", desc = " + desc + ", price = " + price);
                total += unit * price;
            }
        } catch (EOFException e) {
            System.out.println("total = " + total);
        }
        in.close();
    }
}
