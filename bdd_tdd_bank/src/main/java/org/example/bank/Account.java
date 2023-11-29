package org.example.bank;
import org.example.bank.customBankExceptions.*;

public class Account implements IAccount {

    private int balance;

    public Account(int startBalance) {
        this.balance = startBalance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public int getBalance() {
        return balance;
    }


    // Improved transfer method with better error handling
    public void transfer(Account destinationAccount, int amount, Client user) throws InsufficientFundsException, UnauthorizedAccessException {
        if (!user.hasRole("TRANSFER_ROLE")) {
            throw new UnauthorizedAccessException("User lacks permission to perform transfers");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for transfer");
        }
        this.balance -= amount;
        destinationAccount.balance += amount;
    }


}



