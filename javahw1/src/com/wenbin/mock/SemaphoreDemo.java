package com.wenbin.mock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {
    Semaphore semaphore = null;

    public SemaphoreDemo(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public SemaphoreDemo(int max_connection) {
        this.semaphore = new Semaphore(max_connection);
    }

    Lock lock = new ReentrantLock(true);

    Object key = new Object();

    public synchronized void connect () throws InterruptedException {
        semaphore.acquire();
    }

    public synchronized void disconnect () {
        semaphore.release();
    }

    public void doConnection() {
        try {
            connect();

            tasks();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            disconnect();
        }
    }

    public void tasks() {
        try {
            lock.tryLock();
            System.out.println("dummy tasks and thread number is " + (10 - semaphore.availablePermits()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        int count = 100;
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo(10);
        while (count-- > 0) {
            exe.submit(() -> {
                semaphoreDemo.doConnection();
            });
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exe.shutdown();
    }
}
