package com.wenbin.thread;

import java.util.concurrent.*;

public class LachDown {
    public static void main(String[] args) {

//        double sum = 0;
//        for (int i = 0; i < 5; i++) {
//            Task t = new Task();
//            new Thread(t).start();
//            sum += t.sum;
//        }
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("ret is " + sum);
//
//
//        System.out.println("\n======\n");
        /**
         * future
         *
         * */

        double sum = 0;

        double[] ret = new double[5];
        ExecutorService exe = Executors.newCachedThreadPool();
        Future[] futures = new Future[5];
        for (int i = 0; i < 5; i++) {
            futures[i] = exe.submit(new TaskII());
        }

        for (int i = 0; i < 5; i++) {
            try {
                ret[i] = (double)futures[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            sum += ret[i];
        }
        System.out.println("ret is " + sum);
    }
}


class Task implements Runnable {

    double sum;
    @Override
    public void run() {
        sum = Math.random();
        System.out.println("num is " + sum);
    }
}

class TaskII implements Callable {

    @Override
    public Object call() throws Exception {
        return new Double(Math.random());
    }


}
