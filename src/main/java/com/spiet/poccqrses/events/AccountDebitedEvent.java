package com.spiet.poccqrses.events;


import java.math.BigDecimal;

public class AccountDebitedEvent extends CommonEvent<String> {

    private final BigDecimal amount;

    public AccountDebitedEvent(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}