package com.agenthun;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Agent Henry on 2015/8/8.
 */
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("Test 1");
        hashMapTest1();
        System.out.println("Test 2");
        hashMapTest2();
    }

    public static void hashMapTest1() {
        System.out.println("Use user defined class as key: ");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aaa", "bbb");
        hashMap.put("aaa", "ccc");

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key + " " + value);
        }
    }

    public static void hashMapTest2() {
        System.out.println("Use String as key: ");
        HashMap<Person, String> hashMap = new HashMap<>();
        Person p1 = new Person("111", "name1");
        Person p2 = new Person("111", "name1");
        hashMap.put(p1, "address1");
        hashMap.put(p2, "address1");

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Person key = (Person) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key + " " + value);
        }
    }
}

class Person {
    String id;
    String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }

    //注意有无重写equals, hashCode方法!
    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        if (p.id.equals(this.id)) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
