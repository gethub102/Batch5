package com.wenbin.prodcnsume;

public class QII {
    int n;

    boolean falg = false;

    public QII(int n) {
        this.n = n;
    }

    public synchronized int getN() {
        if (!falg) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Latest No Consumed: " + n);
        falg = false;
        notify();
        return n;
    }

    public synchronized void setN(int n) {
        if (falg) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        falg = true;
        System.out.println("number consumed is " + n );
        notify();
    }
}
