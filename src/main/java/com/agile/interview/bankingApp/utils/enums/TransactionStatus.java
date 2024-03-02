package com.agile.interview.bankingApp.utils.enums;

public enum TransactionStatus {
    SUCCESS("200", "Transaction Completed Successfully"),
    FAILED_INSUFFICIENT_BALANCE("500", "Current balance is insufficient to perform this transaction."),

    FAILED_SAME_ACCOUNT("500", "Target account should not be the same as source account."),

    FAILED_ACCOUNT_NOT_FOUND("500", "Target account not found."),
    CURRENCIES_NOT_MATCHING("500", "Transaction currency and target account currency do not match.");

    private final String httpCode;
    private final String message;

    TransactionStatus(String httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public String getMessage() {
        return message;
    }
}
