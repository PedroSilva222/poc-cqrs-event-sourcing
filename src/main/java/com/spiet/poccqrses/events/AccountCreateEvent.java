package com.spiet.poccqrses.events;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class AccountCreateEvent extends CommonEvent<String> {

    private final BigDecimal balance;

    public AccountCreateEvent(String id, BigDecimal balance) {
        super(id);
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
