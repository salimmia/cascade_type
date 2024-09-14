package com.salim.cascadetype.extraModule;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

//@Inheritance
@Entity
@DiscriminatorValue("integer")
public class IntegerWrapper extends NeededType{
    private Integer integerValue;
    public IntegerWrapper(int integerValue) {
        this.integerValue = integerValue;
    }

    public IntegerWrapper() {

    }

    @Override
    public String toString() {
        return integerValue.toString();
    }
}
