package com.salim.cascadetype.student.dto;

import com.salim.cascadetype.course.dto.CourseReqDto;

import java.time.Instant;
import java.util.List;

public record StudentReqDto(
        String firstName,
        String lastName,
        String email,
        Instant dateOfBirth,
        List<Long> courseIds
) {
}
