package com.wenbin.thread;

public class BigMall {
    public void open() {
        System.out.println("mall is open now");
    }

    public void close() {
        System.out.println("mall is close now");
    }

    public static void main(String[] args) {
        BigMall bigMall = new BigMall();
        bigMall.open();

        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");

        movie1.start();
        movie2.start();
        movie3.start();

        try {
            movie1.join();
            movie2.join();
            movie3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bigMall.close();
    }


}

class Movie extends Thread {
    private String movieName;

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public void run() {
        System.out.println(this.getMovieName() + " start ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getMovieName() + " end ");
    }
}
