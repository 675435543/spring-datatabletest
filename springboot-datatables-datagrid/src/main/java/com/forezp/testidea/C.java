package com.forezp.testidea;

import java.util.ArrayList;
import java.util.List;

public class C implements Cloneable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public C() {
    }

    public C(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        C c = new C("小明", 23);
        C c2 = null;
        try {
            c2 = (C) c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        List<C> list = new ArrayList<C>(16);
        list.add(c);
        list.add(c2);
        list.get(1).setName("校长");
        for (C cb : list) {
            System.out.println(cb.getName());
        }
        try {
            System.out.println(c.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }
}
