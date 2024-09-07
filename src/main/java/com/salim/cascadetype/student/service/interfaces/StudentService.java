package com.salim.cascadetype.student.service.interfaces;

import com.salim.cascadetype.student.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Student addNewStudent(Student student);
    Page<Student> getAllStudents(Pageable pageable);
}
