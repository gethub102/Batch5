package com.wenbin.prodcnsume;

public class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }


    @Override
    public void run() {
        int i = 0;
        while (true) {

            synchronized (q) {

                q.setN(i++);
                System.out.println(i + " is procuded--");
                q.notify();
                try {
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

    public static void main(String[] args) {
        Q q = new Q(0);
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
    }
}
