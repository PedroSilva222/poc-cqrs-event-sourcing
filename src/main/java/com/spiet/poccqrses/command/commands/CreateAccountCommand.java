package com.spiet.poccqrses.command.commands;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class CreateAccountCommand extends CommandCommon<String> {
    private final BigDecimal amount;

    public CreateAccountCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
