package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    //Instance variables
    private String name, address, phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    //Methods
    public Accountable[] getAccounts() {
        Accountable[] arrOfAccounts = new Accountable[this.accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            arrOfAccounts[i] = this.accounts.get(i);
        }
        return arrOfAccounts;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int totalBalance = 0;
        int vipStatusAmount = 25000;
        for (Accountable account : accounts) {
            totalBalance += account.getBalance();
        }
        if (totalBalance >= vipStatusAmount) {
            return true;
        }
        else {
            return false;
        }
    }

    //Getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
