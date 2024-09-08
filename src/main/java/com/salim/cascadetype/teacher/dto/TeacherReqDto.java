package com.salim.cascadetype.teacher.dto;

import java.util.List;

public record TeacherReqDto(
    String firstName,
    String lastName,
    String email,
    List<Long> courseIds
) {
}
