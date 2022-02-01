package com.techelevator;

public class CreditCardAccount implements Accountable {
    //Instance variables
    private String accountHolder, accountNumber;
    private int debt;

    //Constructor
    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        debt = 0;
    }

    //Methods
    public int pay(int amountToPay) {
        debt -= amountToPay;
        return debt;
    }

    public int charge(int amountToCharge) {
        debt += amountToCharge;
        return debt;
    }

    public int getBalance() {
        int balance = -this.debt;
        return balance;
    }

    //Getters
    public String getAccountHolder() {
        return this.accountHolder;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getDebt() {
        return this.debt;
    }
}
