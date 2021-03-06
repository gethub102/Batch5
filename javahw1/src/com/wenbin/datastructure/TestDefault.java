package com.wenbin.datastructure;

import com.wenbin.bank.Test;

import java.io.IOException;

public class TestDefault extends Test implements Runnable {
    public TestDefault() {
        super();
        new Thread(this, "counter").start();
    }

    public static void main(String[] args) {
        TestDefault testDefault = new TestDefault();
        System.out.println(testDefault.t);

    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);

                System.out.println(i++);
                Runtime.getRuntime().exec("clear");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
