package org.example.enums;

public enum IgnoredActivityForLastInteraction {
    MARKET_EMAIL_INTERACTION("market email interaction");

    private final String name;

    IgnoredActivityForLastInteraction(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}