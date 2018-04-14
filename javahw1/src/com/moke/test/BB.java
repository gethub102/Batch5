package com.moke.test;

public class BB extends AA {
    public void test() {}
    public static void main(String[] args) {
        BB b = new BB();
        b.setName("you");
        System.out.println(b.getName());
    }

}