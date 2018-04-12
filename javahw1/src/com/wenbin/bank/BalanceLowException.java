package com.wenbin.bank;

public class BalanceLowException extends Exception {
    public BalanceLowException(String message) {
        super(message);
    }
}
