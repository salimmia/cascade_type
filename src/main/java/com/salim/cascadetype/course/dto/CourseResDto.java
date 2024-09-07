package com.salim.cascadetype.course.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salim.cascadetype.teacher.domain.Teacher;
import lombok.Builder;

import java.util.List;

@Builder
public record CourseResDto(
        String courseName,
        String description,
        @JsonProperty("author_id") Long authorId,
        List<Long> teacherIds,
        List<Long> studentIds
) {}
