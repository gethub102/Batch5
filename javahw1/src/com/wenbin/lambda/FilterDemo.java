package com.wenbin.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FilterDemo {
    public static void main(String[] args) {
        List list = Arrays.asList("Apple", "Test", "Banana");

        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean test(String s) {
                return s.length() <= 4;
            }
        };

        predicate.test("testst");

        Predicate<String> l_p = (s) -> s.length() <= 4;

        l_p.test("tete");


        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Function<String, Integer> f = input-> input.length();

        System.out.println(f.apply("tstset"));


        Supplier<Double> s = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };

        Supplier<Double> ss = () -> Math.random();
        System.out.println(ss.get());
    }
}
