package com.salim.cascadetype.teacher.domain;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Teacher extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
