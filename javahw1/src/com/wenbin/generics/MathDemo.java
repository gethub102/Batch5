package com.wenbin.generics;

import java.util.ArrayList;
import java.util.List;

public class MathDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);

        int[] arr = {1,2,3};
        swap(arr, 1, 2);

    }

    public static  <T> void swap(T[] arr, int a, int b) {
        if (a == b) return;
        if (a >= arr.length || b >= arr.length) return;
        if (a < 0 || b < 0) return;

        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return;
    }

    // interface come last

    public static <T extends Number & Comparable> T findMax(List<T> list, int start, int end) {
        List<T> list1 = list.subList(start, end);

        return list1.stream().max((o1, o2) -> o1.compareTo(o2)).get();

    }

    void add(Integer i) {}
    void add(Object i) {}

//    void add(List<Integer> i) {}
//    void add(List<String> i) {}

}
