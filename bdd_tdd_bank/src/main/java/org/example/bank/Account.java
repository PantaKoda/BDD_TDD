package org.example.bank;

public class Account implements IAccount {

    private int balance;

    public Account(int startBalance) {
        this.balance = startBalance;
    }

    @Override
    public void deposit(int amount){
        this.balance += amount;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
