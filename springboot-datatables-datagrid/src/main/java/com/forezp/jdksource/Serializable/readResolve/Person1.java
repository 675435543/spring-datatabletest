package com.forezp.jdksource.Serializable.readResolve;

import com.forezp.jdksource.Serializable.Gender;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person1 implements Serializable {

    private static class InstanceHolder {
        private static final Person1 instatnce = new Person1("John", 31, Gender.MALE);
    }

    public static Person1 getInstance() {
        return InstanceHolder.instatnce;
    }

    private String name = null;

    private Integer age = null;

    private Gender gender = null;

    private Person1() {
        System.out.println("none-arg constructor");
    }

    private Person1(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instatnce;
    }

}
