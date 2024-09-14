package com.salim.cascadetype.mainTask;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("person")
public class Person extends AllowedType {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
