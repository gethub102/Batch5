package com.wenbin.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    int val;
    BinaryTree left, right;

    public BinaryTree(int val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTree() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public static List<Integer> preOrder(BinaryTree head) {
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

    public static void preOrderII(BinaryTree head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static boolean bfs(BinaryTree head, int target) {
        if (head == null) return false;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            BinaryTree tmp = queue.poll();
            if (tmp.val == target) {
                return true;
            }
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(1);
        BinaryTree left = new BinaryTree(2);
        BinaryTree right = new BinaryTree(3);
        BinaryTree right_ = new BinaryTree(5);
        head.left = left;
        head.right = right;
        head.right.right =right_;

        System.out.println(bfs(head, 5));
        System.out.println(bfs(head, 6));

        System.out.println(preOrder(head));

//        preOrderII(head);
    }
}
