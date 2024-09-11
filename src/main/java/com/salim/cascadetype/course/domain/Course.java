package com.salim.cascadetype.course.domain;

import com.fasterxml.jackson.annotation.*;
import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.base.BaseEntity;
import com.salim.cascadetype.student.domain.Student;
import com.salim.cascadetype.teacher.domain.Teacher;
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
public class Course extends BaseEntity {

    private String courseName;

    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JsonIncludeProperties("id")
    private Author author;

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH})
    @JsonIncludeProperties("id")
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH})
    @JsonIncludeProperties("id")
    private Set<Student> students = new HashSet<>();

    public Course() {

    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getCourses().add(this);
    }
    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.getCourses().remove(this);
    }
    public void addStudent(Student student) {
        students.add(student);
        student.getCourses().add(this);
    }
    public void removeStudent(Student student) {
        students.remove(student);
        student.getCourses().remove(this);
    }
}
