package com.wenbin.thread;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {

    private ArrayList<T> list = null;
    Lock lock = new ReentrantLock(true);

    public ThreadSafeList() {
        list = new ArrayList<T>();
    }

    public ThreadSafeList(ArrayList<T> list) {
        this.list = list;
    }


    public ArrayList<T> getList() {
        return list;
    }

    public boolean add(T t) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                list.add(t);
                System.out.println("Added: " + t);
                lock.unlock();
                return true;

            } else {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean remove (int index) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (index < 0 || index >= list.size()) {
                    lock.unlock();
                    return false;
                }
                T element = list.remove(index);
                System.out.println("Removed: " + element);
                lock.unlock();
                return true;
            }
             else return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int size() {
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }


    public static void main(String[] args) {
        ThreadSafeList<Integer> list = new ThreadSafeList<>();



        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);

            }
        });


        Thread add1 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                list.add(i);

            }
        });

        Thread remove = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.remove(0);

            }
        });



        add.start();
        add1.start();


//        remove.start();


        try {
            add.join();
//            remove.join();
            add1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nelements are left are:");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "  ");
        }
        System.out.println("\nsize is " + list.size());
    }
}
