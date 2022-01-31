package com.techelevator;

public class SavingsAccount extends BankAccount {

    //Constructors
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Override Method
    @Override
    public int withdraw(int amountToWithdraw) {
        int serviceCharge = 2;

        if (super.getBalance() - amountToWithdraw > 150) {
            super.withdraw(amountToWithdraw);
        }
        else if (super.getBalance() - amountToWithdraw < 150
                && (super.getBalance() - amountToWithdraw - serviceCharge >= 0)) {
            super.withdraw(amountToWithdraw + serviceCharge);
        }
        else {
            return super.getBalance();
        }

        return super.getBalance();
    }
}
