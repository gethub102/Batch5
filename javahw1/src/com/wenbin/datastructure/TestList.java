package com.wenbin.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("java");
        list.add("c");
        list.add("c++");
        list.add("python");
        String item = (String) list.get(2);
        System.out.println(item);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "!-df");
        map.put(2, "!-ddf");
        map.put(3, "!-drf");
        map.put(4, "!-dff");
        map.put(5, "!-dbf");

        System.out.println(map.get(2));
    }


}
