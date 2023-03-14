package com.spiet.poccqrses.command.commands;

import java.math.BigDecimal;

public class DepositMoneyCommand extends CommandCommon<String> {
    private final BigDecimal amount;

    public DepositMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
