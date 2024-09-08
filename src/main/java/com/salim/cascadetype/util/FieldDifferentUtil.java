package com.salim.cascadetype.util;

import org.springframework.util.StringUtils;

import java.util.Objects;

public class FieldDifferentUtil {
    public static <T> boolean isDifferent(T newValue, T oldValue) {
        if (newValue instanceof String) {
            return StringUtils.hasText((String) newValue) && !Objects.equals(newValue, oldValue);
        }
        return newValue != null && !Objects.equals(oldValue, newValue);
    }
}
