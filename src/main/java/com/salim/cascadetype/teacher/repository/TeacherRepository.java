package com.salim.cascadetype.teacher.repository;

import com.salim.cascadetype.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
