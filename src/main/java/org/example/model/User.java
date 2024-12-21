package org.example.model;

import org.example.enums.State;

import static org.example.enums.State.ACTIVE;

public class User {

    private final String id;
    private State state;

    public User(final String id) {
        this.id = id;
        this.state = ACTIVE;
    }

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }
}