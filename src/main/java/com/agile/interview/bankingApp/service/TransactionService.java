package com.agile.interview.bankingApp.service;

import com.agile.interview.bankingApp.dto.TransactionDTO;
import com.agile.interview.bankingApp.mapper.TransactionMapper;
import com.agile.interview.bankingApp.model.Transaction;
import com.agile.interview.bankingApp.repository.TransactionJpaDao;
import com.agile.interview.bankingApp.utils.enums.TransactionStatus;
import com.agile.interview.bankingApp.repository.TransactionDao;
import com.agile.interview.bankingApp.utils.exception.BusinessValidationException;
import com.agile.interview.bankingApp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private TransactionJpaDao transactionJpaDao;

    @Autowired
    private TransactionMapper transactionMapper;


    @Transactional(rollbackFor = SQLException.class)
    public void transferAmount(TransactionDTO transactionDTO) throws BusinessValidationException {

        Account sourceAccount = this.accountService.retrieveAccount(transactionDTO.getSourceAccount());

        // AC2
        if (sourceAccount.getBalance().compareTo(transactionDTO.getAmount()) < 0) {
            throw new BusinessValidationException(TransactionStatus.FAILED_INSUFFICIENT_BALANCE);
        }

        Account targetAccount = this.accountService.retrieveAccount(transactionDTO.getTargetAccount());

        //AC3
        if (sourceAccount.getId() == targetAccount.getId()) {
            throw new BusinessValidationException(TransactionStatus.FAILED_SAME_ACCOUNT);
        }

        // AC1
        if (transactionDTO.getCurrency().equals(targetAccount.getCurrency().toString())) {
            this.transactionDao.subtractAmount(sourceAccount, transactionDTO.getAmount());
            this.transactionDao.addAmount(targetAccount, transactionDTO.getAmount());
            Transaction transaction = transactionMapper.dtoToModel(transactionDTO);
            transaction.setSourceAccountId(sourceAccount);
            transaction.setTargetAccountId(targetAccount);
            this.transactionJpaDao.save(transaction);
        } else {
            throw new BusinessValidationException(TransactionStatus.CURRENCIES_NOT_MATCHING);
        }

    }
}
