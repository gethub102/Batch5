package com.rjt.training;

public class Manager02 {
    public static void main(String[] args) throws CustomerException {
        int i = 9;
        if (i < 10) {
            throw new CustomerException("i < 10 is an exception");
        }
        System.out.println("this is the end");
    }
}
