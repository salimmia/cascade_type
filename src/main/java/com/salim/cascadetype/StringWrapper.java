package com.salim.cascadetype;

public class StringWrapper implements NeededType{
    private final String value;
    public StringWrapper(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
