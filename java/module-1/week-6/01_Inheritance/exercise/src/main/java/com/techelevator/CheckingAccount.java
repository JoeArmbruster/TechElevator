package com.techelevator;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw > 0) {
            int overdraftFee = 10;
            int totalWithdrawal = amountToWithdraw;

            if (getBalance() - totalWithdrawal >= -100) {
                super.withdraw(totalWithdrawal);
                if (getBalance() < 0) {
                    super.withdraw(overdraftFee);
                }
            }
        }
        return getBalance();
    }
}

