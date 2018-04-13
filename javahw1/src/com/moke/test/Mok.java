package com.moke.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mok {

    int len = 0;
    int[] array = new int[2];

    public int insert(int number) {

        if (this.array.length <= len) {
            int[] tmpArray = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
        }
        array[len++] = number;
        return this.array.length;
    }

    public static void main(String[] args) throws LongExperienceException {
        Mok mk = new Mok();
        mk.insert(1);
        mk.insert(1);
        mk.insert(1);
        mk.insert(1);
        mk.insert(1);

        int[] a = new int[] {1,3,6,8,9,3,1,5,2,1,1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            if (map.containsKey(num)) {
                map.put(num, (map.get(num) + 1));
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(name + "------");
        String last = scanner.nextLine();
        System.out.println(last + "------");
        int n = scanner.nextInt();
        System.out.println(n + "----- ");
        scanner.close();



    }
}
