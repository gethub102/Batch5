package com.wenbin.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;

public class Timer implements Runnable {
    public Timer() {
        new Thread(this, "Timer").start();
    }

    @Override
    public void run() {
        Instant now = Instant.now();
        while (true) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                System.out.println(dateFormat.format(cal.getTime()));
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

    }
}
