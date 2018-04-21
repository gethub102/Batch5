package com.wenbin.datastructure;

import com.moke.test.Person3;

import java.util.*;

public class Person implements Comparable {
    String name;
    int age;
    double weight;
    boolean isMarried;
    String ssn;

    public Person(String name, int age, double weight, boolean isMarried, String ssn) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isMarried = isMarried;
        this.ssn = ssn;
    }

    @Override
    public int hashCode() {
        String _age = String.valueOf(this.age);
        String _w = String.valueOf(weight);

        String _m = this.isMarried ? String.valueOf(1) : String.valueOf(0);
        return _age.hashCode() + _w.hashCode() + _m.hashCode() + this.name.hashCode() + this.ssn.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (p.name.equals(this.name) && p.ssn.equals(this.ssn) && p.age == this.age && p.weight == this.weight && p.isMarried == this.isMarried) {
                return true;
            }
            else  {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age;
    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();

        set.add(new Person("Y_name", 23, 70, true, "83843"));
        set.add(new Person("Y_name", 23, 70, true, "83843"));
        set.add(new Person("Y_name", 23, 70, true, "83843"));
        set.add(new Person("Y_name", 23, 70, true, "83843"));
        System.out.println(set);

        Person person1 = new Person("Y_name", 23, 70, true, "83843");
        Person person2 = new Person("T_name", 33, 70, true, "83843");
        Person person3 = new Person("R_name", 43, 70, true, "83843");
        Person person4 = new Person("H_name", 53, 70, true, "83843");
        Person person5 = new Person("U_name", 63, 70, true, "83843");


        List<Person> list = new ArrayList<>();
        list.addAll(Arrays.asList(person1, person2, person3, person4, person5));

//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.age - o2.age;
//            }
//        });

//        Collections.sort(list, new CompareBasedOnNog());

        Collections.sort(list);
//        System.out.println(list);


        Set treeSt = new TreeSet();
        treeSt.add(1);
        treeSt.add(100);
        treeSt.add(12);
        treeSt.add(13);
        treeSt.add(15);
        treeSt.add(19);
        treeSt.add(1);

        System.out.println(treeSt);

        Set treeStI = new TreeSet();


        treeStI.add(person1);
        treeStI.add(person2);
        treeStI.add(person3);
        System.out.println(treeStI);
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Person)o).age;
    }
}


class CompareBasedOnNog implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return (int) (p1.weight - p2.weight);
    }
}
