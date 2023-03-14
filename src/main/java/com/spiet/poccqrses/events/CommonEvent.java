package com.spiet.poccqrses.events;

public class CommonEvent<T> {

    private final T id;

    public CommonEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
