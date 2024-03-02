package com.agile.interview.bankingApp.repository;

import com.agile.interview.bankingApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaDao extends JpaRepository<Transaction, Integer> {
}
