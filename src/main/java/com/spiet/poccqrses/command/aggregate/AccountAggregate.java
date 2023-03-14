package com.spiet.poccqrses.command.aggregate;

import com.spiet.poccqrses.command.commands.CreateAccountCommand;
import com.spiet.poccqrses.command.commands.DepositMoneyCommand;
import com.spiet.poccqrses.command.commands.WithdrawMoneyCommand;
import com.spiet.poccqrses.events.AccountActivatedEvent;
import com.spiet.poccqrses.events.AccountCreateEvent;
import com.spiet.poccqrses.events.AccountCreditedEvent;
import com.spiet.poccqrses.events.AccountDebitedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
/*
    A anotação @Aggregate serve para o axonic identificar esse compontente como um agregado
 */
@Aggregate
public class AccountAggregate {

    // Essa anotação serve para o Axonic reconhecer o ID da instancia do agregado
    @AggregateIdentifier
    private String accountId;
    private BigDecimal balance;
    private String status;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        log.info("Starting the Create account command...");
        log.info("infos do comando {}", command.toString());
        AggregateLifecycle.apply(new AccountCreateEvent(
                command.getById(),
                command.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreateEvent event) {
        log.info("Account Created Event Received");
        // Vamos atualizar os campos do agregado atualizando os campos da instancia
        this.accountId = event.getId();
        this.balance = event.getBalance();
        this.status = "CREATED";
        log.info("infos do evet {}", event);

        // Quando a conta for criada, precisamos ativá-la e para isso, geraremos um novo evento
        AggregateLifecycle.apply(new AccountActivatedEvent(
            event.getId(),
            "ACTIVATED"
        ));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent event) {
        log.info("Account Created Event Received");
        this.status = event.getStatus();
    }

    @CommandHandler
    public void on(DepositMoneyCommand command) {
        log.info("Starting command to Deposit Money...");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getById(),
                command.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        log.info("Account Credited Event Received");
        this.balance = this.balance.subtract(event.getAmount());
    }

    @CommandHandler
    public void on(WithdrawMoneyCommand command) {
        log.info("Starting command to Deposit Money...");
        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getById(),
                command.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent event) {
        log.info("Account Debit Event Received");
        this.balance = this.balance.add(event.getAmount());
    }
}
