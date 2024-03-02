package com.agile.interview.bankingApp.repository;

import com.agile.interview.bankingApp.model.Account;

import java.math.BigDecimal;

public abstract class TransactionDaoImpl implements TransactionDao {


    @Override
    public void subtractAmount(Account sourceAccount, BigDecimal amount) {

        BigDecimal currentBalance = sourceAccount.getBalance();
        sourceAccount.setBalance(currentBalance.subtract(amount));
    }

    @Override
    public void addAmount(Account targetAccount, BigDecimal amount) {
        BigDecimal currentBalance = targetAccount.getBalance();
        targetAccount.setBalance(currentBalance.add(amount));
    }
}
