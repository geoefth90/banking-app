package com.agile.interview.bankingApp.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SOURCE_ACCOUNT_ID")
    private Account sourceAccountId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TARGET_ACCOUNT_ID")
    private Account targetAccountId;

    @Column(name = "AMOUNT", precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "CURRENCY")
    private Currency currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Account sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Account getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Account targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
