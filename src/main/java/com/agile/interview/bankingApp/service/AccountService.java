package com.agile.interview.bankingApp.service;

import com.agile.interview.bankingApp.utils.enums.TransactionStatus;
import com.agile.interview.bankingApp.utils.exception.BusinessValidationException;
import com.agile.interview.bankingApp.model.Account;
import com.agile.interview.bankingApp.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account retrieveAccount(int id) throws BusinessValidationException {

        Optional<Account> accountOptional = this.accountDao.findById(id);

        //AC4
        if (accountOptional.isEmpty()) {
            throw new BusinessValidationException(TransactionStatus.FAILED_ACCOUNT_NOT_FOUND);
        }
        return accountOptional.get();
    }

}
