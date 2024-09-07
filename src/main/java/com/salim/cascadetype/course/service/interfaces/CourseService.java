package com.salim.cascadetype.course.service.interfaces;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.dto.CourseReqDto;
import com.salim.cascadetype.course.dto.CourseResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Page<Course> getCourses(Pageable pageable);
    CourseResDto addNewCourse(CourseReqDto courseReqDto);
}
