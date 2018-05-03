package com.wenbin.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " : " + name  + " : " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            if (student.name.equals(this.name) && this.id == student.id && this.age == student.id) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Student student1 = new Student(1, "1_name", 11);
        Student student2 = new Student(2, "A_name", 11);
        Student student3 = new Student(3, "B_name", 11);
        Student student4 = new Student(4, "A_name", 11);
        Student student5 = new Student(4, "A_name", 11);
        Student student6 = new Student(5, "C_name", 11);

        Set set = new HashSet();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student5);

        List<Student> list = Stream.of(student1, student2, student3, student4, student5, student4).distinct().filter(o->o.name.startsWith("A")).collect(Collectors.toList());
        list.forEach(o-> System.out.println(o));

        System.out.println("\n\n");

        Set<Student> _set = Stream.of(student1, student2, student3, student4, student5, student4).filter(o->o.name.startsWith("A")).collect(Collectors.toSet());
        _set.forEach(o-> System.out.println(o));

        System.out.println("\n\n");

        Stream<Student> st = set.stream();
        st.filter(o-> o.name.startsWith("A")).collect(Collectors.toList()).forEach(o -> System.out.println(o));
    }
}
