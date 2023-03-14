package com.spiet.poccqrses.query.controller;

import com.spiet.poccqrses.query.entity.Account;
import com.spiet.poccqrses.query.query.FindAccountById;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accounts/query")
public class AccountQueryController {

    //Mesma coisa que CommandGateway, mas dessa vez é para query
    private final QueryGateway queryGateway;

    public AccountQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public ResponseEntity<Account> getAccountById(@RequestParam String id) {
        var acc = queryGateway.
                query(new FindAccountById(id), Account.class).join();
        return ResponseEntity.ok(acc);
    }
}
