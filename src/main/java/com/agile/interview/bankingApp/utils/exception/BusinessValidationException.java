package com.agile.interview.bankingApp.utils.exception;

import com.agile.interview.bankingApp.utils.enums.TransactionStatus;

public class BusinessValidationException extends Exception {

    public BusinessValidationException(TransactionStatus status) {
        super(status.getMessage());
    }
}
