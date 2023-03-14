package com.spiet.poccqrses.command.services;

import com.spiet.poccqrses.command.commands.CreateAccountCommand;
import com.spiet.poccqrses.command.commands.DepositMoneyCommand;
import com.spiet.poccqrses.command.commands.WithdrawMoneyCommand;
import com.spiet.poccqrses.command.dto.CreateAccountRequestDto;
import com.spiet.poccqrses.command.dto.DepositRequestDto;
import com.spiet.poccqrses.command.dto.WithdrawlRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandService {
    private final CommandGateway commandGateway;

    public AccountCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createAccount(CreateAccountRequestDto createAccountRequest) {
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                createAccountRequest.getStartingBalance())
        );
    }

    public CompletableFuture<String> depositToAccount(DepositRequestDto depositRequest) {
        return commandGateway.send(new DepositMoneyCommand(
                depositRequest.getAccountId(),
                depositRequest.getAmount()
        ));
    }

    public CompletableFuture<String> withdrawFromAccount(WithdrawlRequestDto withdrawalRequest) {
        return commandGateway.send(new WithdrawMoneyCommand(
                withdrawalRequest.getAccountId(),
                withdrawalRequest.getAmount()
        ));
    }
}
