package com.agile.interview.bankingApp.repository;

import com.agile.interview.bankingApp.model.Account;

import java.math.BigDecimal;

public interface TransactionDao {
    void subtractAmount(Account sourceAccount, BigDecimal amount);

    void addAmount(Account targetAccount, BigDecimal amount);
}
