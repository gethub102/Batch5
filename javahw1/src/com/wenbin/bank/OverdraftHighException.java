package com.wenbin.bank;

public class OverdraftHighException extends Exception {
    public OverdraftHighException(String message) {
        super(message);
    }
}
