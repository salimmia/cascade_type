package com.salim.cascadetype.util;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.function.Consumer;

public class FieldDifferentUtil {
    public static <T> boolean isDifferent(T newValue, T oldValue) {
        if (newValue instanceof String) {
            return StringUtils.hasText((String) newValue) && !Objects.equals(newValue, oldValue);
        }
        return newValue != null && !Objects.equals(oldValue, newValue);
    }

    public static <T> void updateIfDifferent(T newValue, T oldValue, Consumer<T> updater) {
        if (isDifferent(newValue, oldValue)) {
            updater.accept(newValue);
        }
    }
}
