package com.wenbin.prodcnsume;

public class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Client").start();
    }

    @Override
    public void run() {
        while (true) {

            synchronized (q) {
                try {
                    System.out.println(q.getN() + " is consumed ");
                    q.notify();
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
