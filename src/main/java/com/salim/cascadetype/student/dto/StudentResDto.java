package com.salim.cascadetype.student.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.Set;

@Builder
public record StudentResDto (
        Long id,
        String firstName,
        String lastName,
        String email,
        Instant dateOfBirth,
        Set<Long> courseIds
){
}
