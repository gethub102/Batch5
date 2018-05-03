package com.wenbin.thread;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4);
        int count = 16;
        while (count-- > 0) {
            new CapService(cb);
        }
    }
}

class Passager {
    String name;
    double weight;
}

class CapService implements Runnable {
    CyclicBarrier cb;


    public CapService(CyclicBarrier cb) {
        this.cb = cb;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            int num = cb.await();
            if (num == 0) {
                System.out.println("4 passagers taken the cap");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}