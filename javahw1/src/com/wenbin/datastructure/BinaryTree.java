package com.wenbin.datastructure;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    int val;
    BinaryTree left, right;

    public BinaryTree(int val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTree() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public List<Integer> preOrder(BinaryTree head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        List<Integer> left =  preOrder(head.left);
        List<Integer> right =  preOrder(head.right);
        list.add(head.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    public void preOrderII(BinaryTree head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void main(String[] args) {

    }
}
