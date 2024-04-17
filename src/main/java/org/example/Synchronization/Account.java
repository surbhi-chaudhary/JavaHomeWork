package org.example.Synchronization;

public class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void transfer(Account destination, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }

        if (this.balance < amount) {
            System.out.println("Insufficient balance for transfer.");
            return;
        }

        this.balance -= amount;
        destination.balance += amount;
        System.out.println("Transfer successful: " +amount+ ", transferred from source account to destination account.");
    }

    public synchronized int getBalance() {
        return balance;
    }

}
