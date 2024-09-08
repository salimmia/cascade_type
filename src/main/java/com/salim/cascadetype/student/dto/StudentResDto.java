package com.salim.cascadetype.student.dto;

import com.salim.cascadetype.course.dto.CourseResDto;
import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record StudentResDto (
        Long id,
        String firstName,
        String lastName,
        String email,
        Instant dateOfBirth,
        List<Long> courseIds
){
}
