package com.salim.cascadetype.course.domain;

import com.fasterxml.jackson.annotation.*;
import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.teacher.domain.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Course extends BaseEntity {

    private String courseName;

    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JsonIncludeProperties("id")
    private Author author;

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH})
    @JsonIncludeProperties("id")
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH})
    @JsonIncludeProperties("id")
    private List<Student> students = new ArrayList<>();
}
