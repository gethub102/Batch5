package com.wenbin.bank;

import com.wenbin.io.Person;

public class SavingAccount extends Account {

    final private double minimumBalance;

    public SavingAccount(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public SavingAccount(double balance, Person person, double minimumBalance) {
        super(balance, person);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount < 0) {
            return;
        }
        if ((this.getBalance() - amount) < this.minimumBalance) {
            throw new Exception("Your account should not less than minimum balance: " + this.minimumBalance);
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }
}
