package com.salim.cascadetype.student.domain;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Student extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private Instant dateOfBirth;

    @ManyToMany(cascade = {CascadeType.DETACH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIncludeProperties("id")
    private Set<Course> courses = new HashSet<>();

    public Student() {}

    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }
    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
    }
}
