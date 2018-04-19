package com.wenbin.datastructure;

import java.util.*;

public class CollectionsAndMap {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = new int[] {1,2,3,4,5,6};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        Arrays.sort(arr1);

        int ret = Arrays.binarySearch(arr1, 8);
        System.out.println("ret = " + ret);

        List list = new ArrayList();
        list.add(1);
        list.add("1");
        list.add("Jayant");
        list.add(true);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " --- ");
        }

        list.add(3, 200);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " --- ");
        }

        System.out.println("\n");

        System.out.println(list);


        List list2 = new ArrayList();
        list2.addAll(Arrays.asList(1,2,3, 4,5, 6,7));

        Collections.sort(list2,  Collections.reverseOrder());
        System.out.println(list2);


        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " -- >");
        }

        ListIterator iteratorList =  list2.listIterator(); // farword and reverse
        while (iteratorList.hasNext())
            System.out.println(iteratorList.next());
    }
}
