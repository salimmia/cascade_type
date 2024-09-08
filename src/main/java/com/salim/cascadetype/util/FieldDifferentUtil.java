package com.salim.cascadetype.util;

import java.util.Objects;

public class FieldDifferentUtil {
    public static <T> boolean isDifferent(T newValue, T oldValue) {
        return newValue != null && !Objects.equals(oldValue, newValue);
    }
}
