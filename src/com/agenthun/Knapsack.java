package com.agenthun;

/**
 * Created by Agent Henry on 2015/8/6.
 */
class Fruit {
    private String name;
    private int size;
    private int price;

    public Fruit(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}

public class Knapsack {
    private static final int MAX = 8;
    private static final int MIN = 1;

    public static void main(String[] args) {
        int[] item = new int[MAX + 1];
        int[] value = new int[MAX + 1];
        Fruit[] fruits = {
                new Fruit("李子", 4, 4500),
                new Fruit("苹果", 5, 5700),
                new Fruit("橘子", 2, 2250),
                new Fruit("草莓", 1, 1100),
                new Fruit("甜瓜", 6, 6700)
        };

        for (int i = 0; i < fruits.length; i++) {
            for (int j = fruits[i].getSize(); j <= MAX; j++) {
                int p = j - fruits[i].getSize();
                int newValue = value[p] + fruits[i].getPrice();
                if (newValue > value[j]) {
                    value[j] = newValue;
                    item[j] = i;
                }
            }
        }

        System.out.println("物品\t价格");
        System.out.println("-----------");
        for (int i = MAX; i >= MIN; i = i - fruits[item[i]].getSize()) {
            System.out.println(fruits[item[i]].getName() + "\t" + fruits[item[i]].getPrice());
        }
        System.out.println("-----------");
        System.out.println("合计\t" + value[MAX]);
    }
}
