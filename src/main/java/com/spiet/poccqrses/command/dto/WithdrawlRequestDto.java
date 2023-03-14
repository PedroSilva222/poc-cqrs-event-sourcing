package com.spiet.poccqrses.command.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawlRequestDto {
    private String accountId;
    private BigDecimal amount;

}
