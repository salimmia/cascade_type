package com.salim.cascadetype.teacher.service.interfaces;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.teacher.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TeacherService {
    Page<Teacher> getTeachers(Pageable pageable);
    Optional<Teacher> getTeacher(Long id);
    Teacher updateTeacher(Long id, Teacher teacher);
    Teacher createTeacher(Teacher teacher);
}
