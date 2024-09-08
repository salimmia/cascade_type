package com.salim.cascadetype.teacher.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record TeacherResDto(
    Long id,
    String firstName,
    String lastName,
    String email,
    List<Long> courseIds
) {
}
