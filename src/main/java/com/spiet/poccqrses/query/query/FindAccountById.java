package com.spiet.poccqrses.query.query;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FindAccountById {
    private String accountId;

    public FindAccountById(String accountId) {
        this.accountId = accountId;
    }
}