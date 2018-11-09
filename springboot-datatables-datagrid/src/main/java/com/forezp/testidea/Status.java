package com.forezp.testidea;

public class Status {

    public void foo(){
        System.out.println("foo");
    }
    public void bar(){
        System.out.println("bar");
    }


    private static void hello() {

    }
    public static void main(String[] args) {
        Status status = new Status();
        status.foo();
    }

}
