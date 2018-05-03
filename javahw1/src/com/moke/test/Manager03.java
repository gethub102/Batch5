package com.moke.test;

import java.util.Set;
import java.util.TreeSet;

public class Manager03 {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        Person person1 = new Person("W_naem", 25);
        Person person2 = new Person("E_naem", 24);
        Person person3 = new Person("R_naem", 23);

        set.add(person1);
        set.add(person2);
        set.add(person3);

        System.out.println(set);
    }
}

class Person implements Comparable{
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

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.age - p.age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}
