package com.wenbin.thread;

public class Manager extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("child is going on");
        }
    }

    public static void main(String[] args) {
        SchoolBus schoolBus = new SchoolBus();
        schoolBus.setPriority(Thread.MAX_PRIORITY);
        schoolBus.start();

        Manager manager = new Manager();
        manager.start();
        try {
            schoolBus.join();

            manager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
