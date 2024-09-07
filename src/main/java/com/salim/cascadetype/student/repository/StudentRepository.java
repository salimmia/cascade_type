package com.salim.cascadetype.student.repository;

import com.salim.cascadetype.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
