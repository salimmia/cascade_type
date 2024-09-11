package com.salim.cascadetype.student.dto;

import java.time.Instant;
import java.util.Set;

public record StudentReqDto(
        String firstName,
        String lastName,
        String email,
        Instant dateOfBirth,
        Set<Long> courseIds
) {
}
