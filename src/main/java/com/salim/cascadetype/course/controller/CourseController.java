package com.salim.cascadetype.course.controller;

import com.salim.cascadetype.course.domain.Course;
import com.salim.cascadetype.course.service.interfaces.CourseService;
import com.salim.cascadetype.exception.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course/")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getCourses(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Found courses")
                        .data(courseService.getCourses(pageable))
                        .build());
    }
}
