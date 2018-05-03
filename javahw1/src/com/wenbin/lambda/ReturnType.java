package com.wenbin.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturnType {

    public static void main(String args[]) throws Exception{
        Callable<Double> c= new Callable<Double>(){
            public Double call(){
                return Math.random();
            }
        };
        Double d= c.call();
        System.out.println(d);

        ExecutorService e = Executors.newCachedThreadPool();
        Future<Double> future = e.submit(() ->  {
            return Math.random();
        });

        System.out.println(future.get());
        e.shutdown();


        Callable<Double> call = () ->  Math.random();
        double destination = call.call();
        System.out.println(destination);
    }

}
