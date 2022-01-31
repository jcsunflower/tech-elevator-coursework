package com.techelevator;

public class CheckingAccount extends BankAccount {

    //Constructors
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Override method
    @Override
    public int withdraw(int amountToWithdraw) {
        int overdraft = 10;

        if (super.getBalance() >= amountToWithdraw) {
            super.withdraw(amountToWithdraw);
        }
        else if (super.getBalance() - amountToWithdraw >= -100) {
            super.withdraw(amountToWithdraw + overdraft);
        }
        else {
            return super.getBalance();
        }
        return super.getBalance();
    }
}

