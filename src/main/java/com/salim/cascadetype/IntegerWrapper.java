package com.salim.cascadetype;

public class IntegerWrapper implements NeededType{
    private final Integer value;
    public IntegerWrapper(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
