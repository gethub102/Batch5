package com.wenbin.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        Mylist mylist = new Mylist(list);
        for (int i = 0; i < 100; i++) {
            new Thread(mylist).start();
        }
    }
}

class Mylist implements Runnable {

    public Mylist(List list) {
        this.list = list;
    }

    List list = new ArrayList<>();

    Lock lock = new ReentrantLock(true);

    public void run() {
        lock.lock();
        list.add(Math.random());
        lock.unlock();
    }
}
