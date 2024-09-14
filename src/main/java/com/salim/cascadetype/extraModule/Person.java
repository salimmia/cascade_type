package com.salim.cascadetype.extraModule;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Inheritance
@Entity
@DiscriminatorValue("person")
public class Person extends NeededType {

    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {}
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
