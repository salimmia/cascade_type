package com.salim.cascadetype.course.service.impl;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import com.salim.cascadetype.course.mapper.CourseMapper;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.course.service.interfaces.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public Page<Course> getCourses(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public CourseResDto addNewCourse(CourseReqDto courseReqDto) {
        Course course = courseMapper.toEntity(courseReqDto);
        return courseMapper.toDto(courseRepository.save(course));
    }
}
