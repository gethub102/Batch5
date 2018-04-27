package com.wenbin.Zati;

public class Child extends Parent {
    {
        System.out.println("Instance block");
    }

    String name;

    Child(String name) {
        this();
        System.out.println("name ---");
    }

    public Child() {
        System.out.println("Child ---");
    }

    public static void main(String[] args) {
        Child child = new Child("name");
    }
}
