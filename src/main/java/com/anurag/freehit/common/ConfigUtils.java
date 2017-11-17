package com.anurag.freehit.common;

import java.util.Objects;

public final class ConfigUtils {

    public static Integer getIntScalar(Property property) {
        Objects.requireNonNull(property);
        try {
            return Integer.valueOf(property.getValue());
        } catch (NumberFormatException e) {
        }
        return null;
    }

    public static Long getLongScalar(Property property) {
        Objects.requireNonNull(property);
        try {
            return Long.valueOf(property.getValue());
        } catch (NumberFormatException e) {
        }
        return null;
    }
}
