package com.moke.test;

public class Manager {

    protected int a;
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        System.out.println(myThread.getPriority());
//        myThread.setPriority(1);
//        myThread.start();
//        MyThread01 myThread01 = new MyThread01();
//        Thread thread = new Thread(myThread01);
//        thread.start();
//        for (int i = 1000; i < 2000; i++) {
//            System.out.println(i + "--");
//        }

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        System.out.println("id: " + t1.getId() + " name: " + t1.getName());
        System.out.println("id: " + t2.getId() + " name: " + t2.getName());
        System.out.println("id: " + t3.getId() + " name: " + t3.getName());
        System.out.println("id: " + Thread.currentThread().getId() + " name: " + Thread.currentThread().getName());
    }
}