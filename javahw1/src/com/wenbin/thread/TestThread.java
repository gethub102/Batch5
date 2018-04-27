package com.wenbin.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    List list = new ArrayList();
    Vector vector = new Vector();

    public static void main(String[] args) {
        TestThread testThread = new TestThread();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                testThread.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 50; i < 100; i++) {
                testThread.addII(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("size is " + testThread.list.size() + " : " + testThread.list);

    }



    /**
     * Lock with mutable object
     *
     * */
    public void add(int i) {
        synchronized (list) {

            list.add(i);
        }

    }

    public void addII(int i) {
        synchronized (list) {

            list.add(i);
        }

    }



    /**
     *
     * ReentrantLock test
     *
     * */

//    Lock lock = new ReentrantLock(true);
//
//    public void add(int i) {
//        try {
//            lock.tryLock(12, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        list.add(i);
//        lock.unlock();
//    }


    /**
     * Lock
     *
     * */
//    Object key = new Object();
//
//    public void add(int i) {
//        synchronized (key) {
//
//            list.add(i);
//        }
//
//    }


//    public synchronized void add(int i) {
//            list.add(i);
//    }
}
