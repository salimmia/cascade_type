package com.salim.cascadetype.extraModule;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("string")
public class StringWrapper extends NeededType{
    private String stringValue;
    public StringWrapper(String stringValue) {
        this.stringValue = stringValue;
    }

    public StringWrapper() {

    }

    @Override
    public String toString() {
        return stringValue;
    }
}
