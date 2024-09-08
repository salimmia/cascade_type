package com.salim.cascadetype.course.service.interfaces;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Page<CourseResDto> getCourses(Pageable pageable);
    Optional<CourseResDto> addNewCourse(CourseReqDto courseReqDto);
}
