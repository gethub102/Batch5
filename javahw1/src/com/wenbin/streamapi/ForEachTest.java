package com.wenbin.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Apple", "Banana", "rr"));

        list.forEach((element)-> {
            if (element.length() <= 4) System.out.println(element);
        });

        List list1 = new ArrayList();

        list.forEach((element)-> {
            if (element.length() <= 4) list1.add(element);
        });

        System.out.println(list1);

        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String o) {
                return o.length() <= 4 ? true : false;
            }
        };
    }
}
