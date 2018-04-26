package com.wenbin.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *  Create a Producer-Consumer application. This kind of application shares data between two threads:
 *  the producer that creates the data, and the consumer, that does something with it. The two threads
 *  communicate using a shared object. Coordination is essential: the consumer thread must not attempt
 *  to retrieve the data before the producer thread has delivered it, and the producer thread must not
 *  attempt to deliver new data if the consumer hasn't retrieved the old data.
 *
 *  Max Size of the list should be 5
 * */

public class ProducerAndConsumer {

    Object lock = new Object();

    List list = new ArrayList();
    public static void main(String[] args) {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        pc.producer.start();
        pc.consumer.start();
    }

    Thread producer = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                try {
                    if (list.size() >= 5) {
                        list.notify();
                        list.wait();
                    }
                    else {
                        int num = (int)(Math.random() * 1000) + 1;
                        list.add(num);
                        System.out.println("Added: " + num);
                        Thread.sleep(2000);
                        lock.wait();
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });


    Thread consumer = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                try {
                    if (list.size() > 0) {
                        int num = (int)list.remove(0);
                        System.out.println("Removed: " + num);
                        Thread.sleep(2000);

                    } else {
                        lock.notify();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    } );
}


