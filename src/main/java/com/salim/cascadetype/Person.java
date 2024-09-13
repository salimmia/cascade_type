package com.salim.cascadetype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements NeededType {
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
