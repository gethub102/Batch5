package com.wenbin.datastructure;

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node() {
        this.val = 0;
        this.next = null;
    }
}

public class LinkList {
    Node head;
    Node tail;
    int size;

    public LinkList(Node head, Node tail) {
        if (head == tail && head == null) {
            head = tail;
            size = 0;
        }
        this.head = head;
        this.tail = tail;
        head.next = tail;
        if (head != null) size++;
        if (tail != null) size++;
    }

    public boolean add (Node node) {
        if (head == null) {
            head = tail = node;
            size++;
            return true;
        }

        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print( "  "  + tmp.val);
            tmp = tmp.next;
        }
        System.out.println();

    }
}
