package com.spiet.poccqrses.command.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CommandCommon<T> {

    @TargetAggregateIdentifier
    private final T id;

    public CommandCommon(T id) {
        this.id = id;
    }

    public T getById() {
        return id;
    }
}
