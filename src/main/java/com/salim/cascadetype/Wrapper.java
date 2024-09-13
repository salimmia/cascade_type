package com.salim.cascadetype;

public class Wrapper <T> implements NeededType{
    private final T value;
    public Wrapper(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
