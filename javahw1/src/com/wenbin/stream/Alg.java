package com.wenbin.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Alg {
    public static void main(String[] args) {
        System.out.println(getString(3, 10,25));
        System.out.println(getString(5, 5,15));
        System.out.println(checkRange(5, 5,15));
        System.out.println(checkRangeII(5, 5,15));
        Stream.of(new Alg(), new Alg()).max((o1, o2) -> o1.hashCode() - o2.hashCode()).get();
    }

    public  static String getString(int num, int start, int end) {
        String ret = "uu_";
        if (start >= end) return ret;
        List list = new ArrayList();
        IntStream.rangeClosed(start, end).filter(o -> String.valueOf(o).indexOf(String.valueOf(num)) != -1).forEach(o-> list.add(o));
        for (Object item : list) {
            ret = ret + " " + String.valueOf(item);
        }

        return ret;
    }

    public static String checkRange(int digit, int start, int end) {
        String s= IntStream.rangeClosed(start, end).mapToObj(String::valueOf).filter(x-> x.contains(digit+"")).collect(Collectors.joining(" "));
        return s;
    }

    public static String checkRangeII(int digit, int start, int end) {
        String ret = "";
        if (start >= end) return ret;

        ret = IntStream.rangeClosed(start, end).parallel().mapToObj(String::valueOf).filter(x -> x.contains(digit + ""))
                .collect(Collectors.joining(" "));

        return ret;
    }
}
