package com.salim.cascadetype.course.service.impl;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.course.service.interfaces.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Page<Course> getCourses(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }
}
