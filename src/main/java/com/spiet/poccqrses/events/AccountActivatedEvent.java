package com.spiet.poccqrses.events;

public class AccountActivatedEvent extends CommonEvent<String> {

    private final String status;

    public AccountActivatedEvent(String id, String status) {
        super(id);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
