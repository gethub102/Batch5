package com.moke.test;

public class Bank {
    public void withdraw(Account account, Double amount) {
        if ((account.getBalance() - amount) < 500) {
            System.out.println("amount is less than 500 after withdraw");
            return;
        }
        account.setBalance(account.getBalance() - amount);
    }
    public Account openAccount(String name, Double balance, long accountNumber) {
        return new Account(name, balance, accountNumber);
    }

    public void displayAccount(Account account) {
        System.out.println(" account number: " + account.getAccountNumber() + " name: " + account.getName() + " balance: " + account.getBalance());
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account = bank.openAccount("Wenbin Li", 55000.00, 83734133434l);
        bank.displayAccount(account);
    }
}
