package com.salim.cascadetype.course.service.impl;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import com.salim.cascadetype.course.mapper.CourseMapper;
import com.salim.cascadetype.course.repository.CourseRepository;
import com.salim.cascadetype.course.service.interfaces.CourseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public Page<CourseResDto> getCourses(Pageable pageable) {

        return courseRepository.findAll(pageable)
                .map(courseMapper::toDto);
    }

    @Override
    public Optional<CourseResDto> addNewCourse(CourseReqDto courseReqDto) {
        Course course = courseMapper.toEntity(courseReqDto);
        return Optional.of(courseMapper.toDto(courseRepository.save(course)));
    }
}
