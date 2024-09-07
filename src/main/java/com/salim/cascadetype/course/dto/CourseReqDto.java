package com.salim.cascadetype.course.dto;

import java.util.List;

public record CourseReqDto(
        String courseName,
        String description,
        Long authorId,
        List<Long> teacherIds,
        List<Long> studentIds
) {
}
