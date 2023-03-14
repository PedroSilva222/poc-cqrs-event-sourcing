package com.spiet.poccqrses.command.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class CreateAccountRequestDto {
    private BigDecimal startingBalance;
}