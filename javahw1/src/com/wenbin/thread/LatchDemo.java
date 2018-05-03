package com.wenbin.thread;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

public class LatchDemo {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(4);

        GetRandomNumber[] objs = new GetRandomNumber[4];
        CountDownLatch latch = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            objs[i] = new GetRandomNumber(latch);
            exe.submit(objs[i]);
        }

        try {
            latch.await();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                max = Math.max(objs[i].value, max);
            }
            System.out.println("max is " + max);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            exe.shutdown();
        }



    }
}

class GetRandomNumber implements Callable {
    int value;
    CountDownLatch latch;

    public GetRandomNumber(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Object call() throws Exception {
        int num = (int) (Math.random() * 1000);
        System.out.println("random from " + Thread.currentThread().getName() + " is " + num);
        this.value = num;
        latch.countDown();
        return new Integer(num);
    }
}
