package com.moke.test;

import java.io.IOException;

public class Child extends Parent {
    public Child() {
    }

    public Child(int a) {
        super(a);
    }
}

class Parent {
    public Parent() {
        System.out.println("Parent const");
    }

    public Parent(int a) {
        this();
        System.out.println("Parent const" + a);
    }
}
