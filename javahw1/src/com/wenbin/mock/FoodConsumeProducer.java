package com.wenbin.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FoodConsumeProducer {
    List<Integer> table = new ArrayList<Integer>(10);

    public FoodConsumeProducer(int capcity) {
        this.table = new ArrayList<Integer>(capcity);
    }

    Lock lock = new ReentrantLock(true);

    Object key = new Object();

    Random random = new Random();

    public void producer() throws InterruptedException {
        synchronized (key) {
            while (true) {
                while (table.size() >= 10) {
                    key.wait();
                }
                Thread.sleep(1000);
                int num = random.nextInt(100);
                table.add(num);
                System.out.println(num + " : " + table.size());
                key.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (key) {
            while (true) {
                while (table.size() == 0) {
                    key.wait();
                }
                Thread.sleep(1000);
                System.out.println(table.remove(0) + " : size " + table.size());
                key.notify();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        FoodConsumeProducer foodConsumeProducer = new FoodConsumeProducer(10);
        exe.submit(() -> {
            try {
                foodConsumeProducer.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        exe.submit(() -> {
            try {
                foodConsumeProducer.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
