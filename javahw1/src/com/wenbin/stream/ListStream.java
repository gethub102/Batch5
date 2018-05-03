package com.wenbin.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListStream {


    public static void main(String[] args) {
        List<String>  list = Arrays.asList("a", "aa", "te");
        list.forEach(a -> System.out.println(a));

//        list.add("last");
//        list.forEach(a -> System.out.println(a));

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        int ret = list1.stream().filter(i -> i % 2 == 0).reduce(0, (a, b) -> a + b);
        System.out.println(" ret = " + ret);
//        int ret1 = list1.parallelStream().filter(i -> i % 2 == 0).reduce(1,(c, d) -> c * d, (a, b) -> a + b);
        int ret1 = list1.parallelStream().filter(i -> i % 2 == 0).reduce(1, (c, d) -> c * d, (a, b) -> a + b);
        ret1 = list1.parallelStream().filter(i -> i % 2 == 0).reduce(1, (a, b) -> a + b);
        System.out.println(" ret1 = " + ret1);

        List<Integer> list2 = Arrays.asList(2, 3, 4);
        //Here result will be 2*2 + 2*3 + 2*4 that is 18.
        int res = list2.parallelStream().reduce(3, (s1, s2) -> s1 * s2, (p, q) -> p + q);
        System.out.println(res);

//        System.out.println(list2);

        res = list2.parallelStream().reduce(2,  (p, q) -> p * q);
        System.out.println(res);

    }
}
