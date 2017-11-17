package com.anurag.freehit.common;

public enum Property {
    RNG_SEED("rng.seed", "100");

    Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    private final String key;
    private final String value;
}
