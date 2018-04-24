package com.wenbin.datastructure;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
//        Map map = new HashMap();
//        map.put("A", "Jay");
//        map.put("B", "Wenbin");
//        map.put("C", "Jay");
//
//        Object key = null;
//        Set keys = map.keySet();
//        Iterator it = keys.iterator();
//        while (it.hasNext()) {
//            key = it.next();
//            System.out.println(key + " : " + map.get(key));
//        }
//
//        System.out.println("\n==========\n");
//
////        Map.Entry entry = (Map.Entry) map.entrySet();
//        Map.Entry entry = null;
//        Set entrySet =  map.entrySet();
//        it = entrySet.iterator();
//        while (it.hasNext()) {
//            entry = (Map.Entry) it.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        Map tm = new TreeMap();
        tm.put("A", "Jay");
        tm.put("B", "Wenbin");
        tm.put("C", "Jay1");
        tm.put("D", "Jay2");
        tm.put("E", "Jay3");

        Map.Entry enty = null;
        Iterator<Map.Entry> iterator = tm.entrySet().iterator();
        while (iterator.hasNext()) {
            enty = iterator.next();
            System.out.println(enty.getKey() + " : " + enty.getValue());
        }
        tm.put("F", "YU");
        Test test = new Test();
        tm.put(test, "This is a test");

        System.out.println("\n==============\n");

        iterator = tm.entrySet().iterator();
        while (iterator.hasNext()) {
            enty = iterator.next();
            System.out.println(enty.getKey() + " : " + enty.getValue());
        }

    }


}


class Test implements Comparable {
    String name = "default";

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj.toString());
    }

    @Override
    public int compareTo(Object o) {
        String obj = String.valueOf(o);
        return obj.compareTo(this.name);
    }
}