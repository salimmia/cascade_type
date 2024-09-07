package com.salim.cascadetype.course.service.interfaces;

import com.salim.cascadetype.course.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Page<Course> getCourses(Pageable pageable);
}
