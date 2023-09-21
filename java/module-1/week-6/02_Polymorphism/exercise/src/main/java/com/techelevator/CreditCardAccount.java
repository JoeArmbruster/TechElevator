package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountHolder;
    private String accountNumber;
    private int debt;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

    public int pay(int amountToPay) {
//        if (amountToPay >= 0 && amountToPay <= debt) {
//            debt -= amountToPay;
//        }
        debt -= amountToPay;
        return -debt;
    }

    public int charge(int amountToCharge) {
        if (amountToCharge > 0) {
            debt += amountToCharge;
        }
        return debt;
    }

    @Override
    public int getBalance() {
        return -debt;
    }
}

