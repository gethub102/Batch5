package com.wenbin.bank;

import com.wenbin.io.Person;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    @Override
    public void withdraw(double amount) throws OverdraftHighException, BalanceLowException {
        if (overdraftLimit < amount) {
            throw new OverdraftHighException("over draft is higher than your limit in your current account");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

}
