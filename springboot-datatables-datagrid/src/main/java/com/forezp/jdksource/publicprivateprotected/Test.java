package com.forezp.jdksource.publicprivateprotected;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test
{
    private int a;
    protected int b;
    public int c;
    int d;
    
    public Test()
    {
        
    }

    public Test(int a, int b, int c, int d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

/*    public static void main(String[] args){
    Test demo=new Test(0, 1, 2, 3);
    int test1=demo.a;
    int test2=demo.b;
    int test3=demo.c;
    int test4=demo.d;
    System.out.println("test1"+test1);
    System.out.println("test2"+test2);
    System.out.println("test3"+test3);
    System.out.println("test4"+test4);
    }*/
}

