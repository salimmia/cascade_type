package com.salim.cascadetype.student.domain;

import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Student extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
