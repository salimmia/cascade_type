package com.salim.cascadetype;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CascadeTypeApplication {
    public static void main(String[] args) throws Exception {

//        SpringApplication.run(CascadeTypeApplication.class, args);
        Run();
    }

    public static void Run() throws Exception {
        Person person = new Person();
        person.setAge(10);
        person.setName("John");

        IntegerWrapper val = new IntegerWrapper(10);
        StringWrapper st = new StringWrapper("Salim");

        Manager<NeededType> manager = new Manager<>();
        manager.add(person);
        manager.add(val);
        manager.add(st);
        Integer a = 10;

        manager.addList(List.of(person, val, st));

        System.out.println(manager.getArray());

        Wrapper<Integer> wrapper = new Wrapper<>(10);
        Wrapper<String> wrapper2 = new Wrapper<>("Muhammad Salim");
        Wrapper<Person> wrapper3 = new Wrapper<>(person);

        Manager<NeededType> manager2 = new Manager<>();
        manager2.addList(List.of(wrapper, wrapper2, wrapper3));
        System.out.println(manager2.getArray());
    }
}
