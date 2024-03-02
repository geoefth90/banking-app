package com.agile.interview.bankingApp.repository;

import com.agile.interview.bankingApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
