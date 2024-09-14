package com.salim.cascadetype.mainTask;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("string")
public class StringWrapper extends AllowedType {

    private String value;

    public StringWrapper() {}

    public StringWrapper(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
