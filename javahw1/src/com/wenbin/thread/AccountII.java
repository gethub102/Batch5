package com.wenbin.thread;

public class AccountII {
    private int accountNumber;
    private int balance;
    private String name;

    public AccountII(int accountNumber, int balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void withDraw(int amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.balance -= amount;
            System.out.println("balance is " + this.balance);
        }
        else {
            System.out.println("Don't try to be smart");
        }
    }

    public static void main(String[] args) {
        AccountII accountII = new AccountII(12345, 5000, "Jay");
        ATM atm = new ATM(accountII);
        InternetAccount internetAccount = new InternetAccount(accountII);
        MobAccount mobAccount = new MobAccount(accountII);

        atm.start();
        internetAccount.start();
        mobAccount.start();

    }
}


class ATM extends Thread {
    AccountII accountII;

    public ATM(AccountII accountII) {
        this.accountII = accountII;
    }

    @Override
    public void run() {
        accountII.withDraw(5000);
    }
}

class InternetAccount extends Thread {
    AccountII accountII;

    public InternetAccount(AccountII accountII) {
        this.accountII = accountII;
    }

    @Override
    public void run() {
        accountII.withDraw(5000);
    }
}

class MobAccount extends Thread {
    AccountII accountII;

    public MobAccount(AccountII accountII) {
        this.accountII = accountII;
    }

    @Override
    public void run() {
        accountII.withDraw(5000);
    }
}