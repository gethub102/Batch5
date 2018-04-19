package com.wenbin.timer;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.lang.Thread;

public class TimeInSecond extends Frame implements Runnable
{
    private Label lblOne;
    private Date dd;
    private Thread th;
    private Calendar calendar;

    public TimeInSecond()
    {
        setTitle("Current time");
        setSize(200,150);
        setVisible(true);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClose(WindowEvent we){
                System.exit(0);
            }
        });


        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        calendar = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar.getTime()));

        lblOne = new Label("00:00:00");
        add(lblOne);

        th = new Thread(this);
        th.start(); // here thread starts
    }

    public void run()
    {
        try
        {
            do
            {
                dd = new Date();
                lblOne.setText(String.valueOf(calendar.getTime()));
                Thread.sleep(1000);  // 1000 = 1 second
            }while(th.isAlive());
        }
        catch(Exception e)
        {

        }
    }

    public static void main(String[] args)
    {
        new TimeInSecond();
    }
}