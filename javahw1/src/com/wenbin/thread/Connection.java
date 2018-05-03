package com.wenbin.thread;

import java.util.concurrent.Semaphore;

public class Connection<T> {

    private static Connection INSTANCE= new Connection();
    private int noOfConnections;
    private Connection(){

    }

    public static Connection getInstance(){
        return INSTANCE;
    }

    Semaphore semaphore = new Semaphore(10);

//    public void connect(){
//
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        synchronized(this){
//
//            noOfConnections++;
//            System.out.println("Current connection "+ noOfConnections);
//        }
//        try{
//            Thread.sleep(200);
//        }catch(Exception e){}
//        finally {
//
//            semaphore.release();
//        }
//
//        synchronized(this){
//            noOfConnections--;
//
//            System.out.println("Disconnecting -- Current connection "+ noOfConnections);
//        }
//
//    }


    public void connect(){
        try{
            semaphore.acquire();
            System.out.println("No. of connections available"+ semaphore.availablePermits());

            synchronized(this){

                noOfConnections++;
                System.out.println("Current connection "+ noOfConnections);
            }
            try{
                Thread.sleep(200);
            }catch(Exception e){}
            synchronized(this){
                noOfConnections--;

                System.out.println("Current connection "+ noOfConnections);
            }
        }catch(Exception e){}
        finally{
            semaphore.release();
        }
    }



}
