package com.wenbin.stream;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Five {
    public static void main(String[] args) {
        Student student1 = new Student(1, "1_name", 11);
        Student student2 = new Student(2, "A_name", 11);
        Student student3 = new Student(3, "B_name", 11);
        Student student4 = new Student(4, "A_name", 11);
        Student student5 = new Student(5, "C_name", 11);

        Function<String,String> f1= x->x.substring(2);
        Function<String, Integer> f2= x-> x.length();

        Stream.of("abcd","hello world", "parrot").map(f1).map(f2).collect(Collectors.toList()).toArray();
//        String[] arr = Stream.of("abcd","hello world", "parrot").map(f1).map(f2).toArray(o -> o + "");




    }
}

