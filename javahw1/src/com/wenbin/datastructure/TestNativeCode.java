package com.wenbin.datastructure;

import java.io.IOException;

public class TestNativeCode implements Runnable {

    public TestNativeCode() {
        new Thread(this, "Native Code").start();
    }

    public static void main(String[] args) {
        TestNativeCode testNativeCode = new TestNativeCode();
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
