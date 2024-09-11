package com.salim.cascadetype.teacher.domain;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.course.domain.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Course> courses = new HashSet<>();

    public Teacher() {}

    public void addCourse(Course course) {
        courses.add(course);
        course.getTeachers().add(this);
    }
    public void removeCourse(Course course) {
        courses.remove(course);
        course.getTeachers().remove(this);
    }
}
