package com.wenbin.io;

import com.wenbin.bank.Account;
import com.wenbin.bank.BalanceLowException;

public class Main {

    public static void main(String[] args) throws Exception {
        Person smith = new Person("Smith", 20);
        Person kathy = new Person("Kathy", 20);

        Account smithAccount = new Account(2000, smith);
        Account kathyAccount = new Account(3000, kathy);

        smithAccount.deposit(2000);
        kathyAccount.withdraw(2000);

        smithAccount.displayBalance();
        kathyAccount.displayBalance();



    }
}
