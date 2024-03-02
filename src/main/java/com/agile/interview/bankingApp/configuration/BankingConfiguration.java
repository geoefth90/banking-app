package com.agile.interview.bankingApp.configuration;

import com.agile.interview.bankingApp.model.Account;
import com.agile.interview.bankingApp.repository.TransactionDao;
import com.agile.interview.bankingApp.repository.TransactionDaoImpl;
import com.agile.interview.bankingApp.service.TransactionService;
import com.agile.interview.bankingApp.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class BankingConfiguration {

    @Bean
    public TransactionService transactionService() {
        return new TransactionService();
    }

    @Bean
    public AccountService accountService() {
        return new AccountService();
    }

    @Bean
    public TransactionDao transactionDao() {
        return new TransactionDaoImpl() {
            @Override
            public void subtractAmount(Account sourceAccount, BigDecimal amount) {
                super.subtractAmount(sourceAccount, amount);
            }

            @Override
            public void addAmount(Account targetAccount, BigDecimal amount) {
                super.addAmount(targetAccount, amount);
            }
        };
    }
}
