package com.salim.cascadetype.course.domain;

import com.fasterxml.jackson.annotation.*;
import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.teacher.domain.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Course extends BaseEntity {

    private String courseName;

    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    @JsonIncludeProperties("id")
    private Author author;

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
