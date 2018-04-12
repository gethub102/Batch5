package com.moke.test;

public class Account {
    private String name;
    private double balance;
    private long accountNumber;


    public Account() {
    }

    public Account(String name, double balance, long accountNumber) {

        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
