package com.wenbin.thread;

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        Thread t1 = new Thread(oddThread);
        Thread t2 = new Thread(evenThread);

        t1.start();
        t2.start();
        t1.join();
        t1.join();

        System.out.println("sum of odd is " + oddThread.sum + " sum of even is " + evenThread.sum);

    }
}

class OddThread implements Runnable {

    int sum = 0;

    public OddThread() {
//        new Thread(this, "Odd Thread").start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i+=2) {
            sum += i;
        }
        System.out.println("Odd number is done by " + Thread.currentThread().getName());
    }
}

class EvenThread implements Runnable {
    int sum = 0;

    public EvenThread() {
//        new Thread(this, "Even").start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i+=2) {
            sum += i;
        }
        System.out.println("Even number is done by " + Thread.currentThread().getName());
    }
}