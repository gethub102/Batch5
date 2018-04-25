package com.wenbin.thread;

public class ThreadLocalTest  {


    public static void main(String[] args) {
        ThreadLocal<Integer> obj = new ThreadLocal<>();
        obj.set(10);
        Thread t1 = new Thread(new ThreadII(obj));
        Thread t2 = new Thread(new ThreadII(obj));
        t1.start();
        t2.start();
    }
}

class ThreadII implements Runnable {

    ThreadLocal<Integer> obj = new ThreadLocal();

    public ThreadII(ThreadLocal<Integer> obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        int x = this.obj.get();
        for (int i = 0; i < x; i++) {
            System.out.println(x++);
        }
    }
}
