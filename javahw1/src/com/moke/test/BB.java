package com.moke.test;

public class BB extends AA {
    @Override
    public Integer out() {return null;}
    public static void main(String[] args) {
        BB b = new BB();
        b.setName("you");
        System.out.println(b.getName());


    }

}