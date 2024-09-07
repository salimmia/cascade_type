package com.salim.cascadetype.course.repository;

import com.salim.cascadetype.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
