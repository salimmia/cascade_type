package com.salim.cascadetype.mainTask;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Manager<T extends AllowedType> {

    private final List<Object> array = new ArrayList<>();

    public void add(T obj) {
        array.add(obj);
    }

    public void addList(List<? extends AllowedType> list) {
        array.addAll(list);
    }

    public void printContents() {
        array.forEach(System.out::println);
    }
}
