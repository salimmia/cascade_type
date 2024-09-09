package com.salim.cascadetype.course.service.interfaces;

import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CourseService {
    Page<CourseResDto> getCourses(Pageable pageable);
    Optional<CourseResDto> addNewCourse(CourseReqDto courseReqDto);
    Optional<CourseResDto> getCourse(Long id);
    Optional<CourseResDto> updateCourse(Long id, CourseReqDto courseReqDto);
    void deleteCourse(Long id);
}
