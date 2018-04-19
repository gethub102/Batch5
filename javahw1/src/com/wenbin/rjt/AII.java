package com.wenbin.rjt;

public class AII extends Thread {
    protected int a = 10;

    public AII() {
    }

    public AII(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        AII aii = new AII();
        aii.start();
        for (int i = 10; i < 30; i++) {
            System.out.println(i + "---");
        }
        try {
            aii.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            aii.start();
        } catch (Exception e) {
            System.out.println("******in the catch");
            e.printStackTrace();
        }

        System.out.println("end~~~~~~~~~");
    }
}
