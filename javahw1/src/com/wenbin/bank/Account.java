package com.wenbin.bank;

import com.wenbin.io.Person;

import java.time.LocalDateTime;

public class Account {
    final private long accountNumber;
    private double balance;
    private Person accountHolder;


    public Account(double balance, Person person) {
        this.balance = balance;
        this.accountHolder = person;
        this.accountNumber = person.hashCode() + LocalDateTime.now().hashCode();
    }

    public Account() {
        this.accountNumber = this.accountHolder.hashCode() + LocalDateTime.now().hashCode();
    }

    public long getAccountNumber() {
        return accountNumber;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws BalanceLowException {
        if (balance < 500) throw new BalanceLowException("Balance should not be low than 500");
        else this.balance = balance;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Person accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void deposit(double amount) throws BalanceLowException {
        if ((this.balance + amount) < 500) {
            throw new BalanceLowException("Balance should not be less than 500");
        }
        else this.balance += amount;
    }

//    public abstract void withdraw(double amount) throws Exception;

    public void withdraw(double amount) throws Exception {
        if ((this.balance + amount) < 500) {
            throw new BalanceLowException("Balance should not be less than 500");
        }
        else this.balance -= amount;
    }

    public void displayBalance() {
        System.out.println(this.accountHolder + "'s balance is " + this.balance);
    }

    @Override
    public String toString() {
        return "account number: " + this.accountNumber + " account houlder: " + this.accountNumber + " balance: " + this.balance;
    }
}
