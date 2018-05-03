package com.wenbin.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConnectionNumber {
    public static void main(String[] args) {
        ExecutorService svc= null;
        try{
            svc=Executors.newCachedThreadPool();
            for(int i=0; i<=100; i++){
                svc.execute(()->Connection.getInstance().connect());
            }
        }finally{
            if(svc!= null){
                svc.shutdown();
            }
        }

    }
}
