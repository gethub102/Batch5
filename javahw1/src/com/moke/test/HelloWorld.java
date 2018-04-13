package com.moke.test;

import java.lang.reflect.Array;
import java.util.*;

public class HelloWorld{

    public static void main(String []args){

        int[] nums = new int[] {1,2,3,3,4,5,6,8,7};

        int[] ret = oddEevenSplit(nums);

        for (int num : ret) {
            System.out.println(num);
        }

        int[] nums1 = new int[] {1,2,4,5,56};
        int[] nums2 = new int[] {2,3,4,5,6,9};
        int[] nums3 = new int[] {2,3,7,5,6,9};

        System.out.println("--------");
        ret = findCommonelement(nums1, nums2, nums3);
        for (int num : ret) {
            System.out.println(num);
        }

    }

    public static int[] oddEevenSplit(int[] nums) {

        Arrays.sort(nums);
        List<Integer> evelist = new ArrayList<>();
        List<Integer> oodlist = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] ret = new int[nums.length];

        for (int num : nums) {
            if (num % 2 == 0) {
                evelist.add(num);
            } else {
                oodlist.add(num);
            }
        }
        for (int i = 0; i < evelist.size(); i++) {
            ret[i] = evelist.get(i);
        }
        for (int i =0; i < oodlist.size(); i++) {
            ret[i + evelist.size()] = oodlist.get(i);
        }
        return ret;

    }

    public static int[] findCommonelement(int[] nums1, int[] nums2, int[] nums3) {
        if (nums1 == null || nums2 == null || nums3 == null || nums1.length == 0 || nums2.length == 0 || nums3.length == 0) {
            return new int[] {};
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        for (int num : nums3) {
            if (set2.contains(num)) {
                set3.add(num);
            }
        }
        int[] ret = new int[set3.size()];
        int index = 0;
        for (int num : set3) {
            ret[index++] = num;
        }
        return ret;
    }
}
