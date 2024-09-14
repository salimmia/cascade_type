package com.salim.cascadetype.mainTask;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Manager<T> {

    private final List<Object> array = new ArrayList<>();

    public <V extends AllowedType>void add(V obj) {
        array.add(obj);
    }

//    public void add(T person) {
//        array.add(person);
//    }

    public <V extends AllowedType> void addList(List<V> list) {
        array.addAll(list);
    }

    public void printContents() {
        array.forEach(System.out::println);
    }
}
