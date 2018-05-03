package com.wenbin.thread;

import java.util.concurrent.Semaphore;

public class ConnSemaphoreTest2 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i <= 100; i ++){

            new Thread(() -> {
                try {
                    // Acquire
                    semaphore.acquire();

                    System.out.println("Acquired: " + Thread.currentThread().getName()
                            + " permits:" + semaphore.availablePermits());

                    // connect()
                    Connection.getInstance().connect();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Release
                    semaphore.release();

                    System.out.println("Released: " + Thread.currentThread().getName()
                            + " permits:" + semaphore.availablePermits());
                }

            }).start();
        }
    }
}