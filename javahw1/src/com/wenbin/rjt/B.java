package com.wenbin.rjt;

public class B extends A {
    int j = 20;
    public static void main(String[] args) {
        A a1 = new B();
        System.out.println(a1.i);
        B b = (B)a1;
        System.out.println(b.j);
    }
}
