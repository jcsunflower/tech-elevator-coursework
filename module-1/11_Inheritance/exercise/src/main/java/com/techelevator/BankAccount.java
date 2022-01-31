package com.techelevator;

public class BankAccount {
    //Instance variables
    private String accountHolderName, accountNumber;
    private int balance;

    //Constructor if there is nothing in balance
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = 0;
    }

    //Constructor if balance is specified
    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Methods
    public int deposit(int amountToDeposit) {
        balance += amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;
    }

    //Getters
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }
}
