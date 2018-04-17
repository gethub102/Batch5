package com.moke.test;

public class Person1 {
    Person2 person2 = null;
    Office office = null;

    public Person1() {
        person2 = new Person2();
        this.office = new Office();
    }

    public Person1(Person2 person2, Office office) {
        this.person2 = person2;
        this.office = office;
    }
}
