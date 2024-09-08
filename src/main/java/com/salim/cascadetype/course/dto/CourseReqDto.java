package com.salim.cascadetype.course.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CourseReqDto(
        String courseName,
        String description,
        Long authorId,
        List<Long> teacherIds,
        List<Long> studentIds
) {
}
