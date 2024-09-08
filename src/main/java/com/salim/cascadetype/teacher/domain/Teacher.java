package com.salim.cascadetype.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.Mergeable;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Teacher extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH})
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIncludeProperties("id")
    private List<Course> courses = new ArrayList<>();

    public Teacher() {

    }
}
