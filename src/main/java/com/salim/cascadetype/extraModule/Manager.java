package com.salim.cascadetype.extraModule;

import java.util.ArrayList;
import java.util.List;

public class Manager <T extends NeededType>{

    List<NeededType> array = new ArrayList<>();

    public <U extends T> void add(U obj){
        array.add(obj);
    }

    public void addList(List<? extends NeededType> list){
        array.addAll(list);
    }

    public List<NeededType> getArray() {
        return array;
    }
}
