package com.spiet.poccqrses.command.controller;

import com.spiet.poccqrses.command.dto.CreateAccountRequestDto;
import com.spiet.poccqrses.command.dto.DepositRequestDto;
import com.spiet.poccqrses.command.dto.WithdrawlRequestDto;
import com.spiet.poccqrses.command.services.AccountCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/v1/accounts")
public class AccountController {

    private final AccountCommandService service;

    public AccountController(AccountCommandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequestDto dto)
            throws ExecutionException, InterruptedException {
        var res = service.createAccount(dto);
        return ResponseEntity.ok(res.get());
    }

    @PutMapping(value = "/deposit")
    public ResponseEntity<String> depositMoney(DepositRequestDto dto)
            throws ExecutionException, InterruptedException {
        var res = service.depositToAccount(dto);
        return ResponseEntity.ok(res.get());
    }

    @PutMapping(value = "/withdraw")
    public ResponseEntity<String> withDraw(WithdrawlRequestDto dto)
            throws ExecutionException, InterruptedException {
        var res = service.withdrawFromAccount(dto);
        return ResponseEntity.ok(res.get());
    }
}
