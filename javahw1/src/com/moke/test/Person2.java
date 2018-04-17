package com.moke.test;

public class Person2 {
    public boolean getFriend() {
        Person3 person3 = new Person3();
        if (person3.accept()) {
            return true;
        }
        return false;
    }
}
