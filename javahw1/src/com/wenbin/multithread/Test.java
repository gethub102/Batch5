package com.wenbin.multithread;

import java.time.LocalTime;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Flag flag = new Flag("x");

        DisplayTime displayTime = new DisplayTime(flag);
        Controller controller = new Controller(flag);

        Thread d = new Thread(displayTime);
        Thread c = new Thread(controller);

        d.start();
        c.start();

    }
}

class Flag {
    String flag;

    public Flag(String flag) {
        this.flag = flag;
    }
}

class DisplayTime implements Runnable {
    volatile Flag flag;

    public DisplayTime(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        LocalTime now = null;
        while (true) {
            if (flag.flag.equals("y")) {
                now = LocalTime.now();
                System.out.println(now);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Controller implements Runnable {

    volatile Flag flag;

    public Controller(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = String.valueOf(scanner.next());
                Thread.sleep(1000);
                if (input.equals("y")) {
                    this.flag.flag = "y";
                } else {
                    this.flag.flag = "x";
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}