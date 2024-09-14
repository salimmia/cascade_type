package com.salim.cascadetype.mainTask;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Entity
@DiscriminatorValue("group")
public class Group extends AllowedType {

    private String groupName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Set<Person> people;

    public Group() {}

    public Group(String groupName, Set<Person> people) {
        this.groupName = groupName;
        this.people = people;
    }

    @Override
    public String toString() {
        return "Group{groupName='" + groupName + "', people=" + people + "}";
    }
}
