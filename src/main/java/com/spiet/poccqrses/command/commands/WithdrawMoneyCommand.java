package com.spiet.poccqrses.command.commands;

import java.math.BigDecimal;

public class WithdrawMoneyCommand extends CommandCommon<String> {

    private final BigDecimal amount;

    public WithdrawMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}