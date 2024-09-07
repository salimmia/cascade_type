package com.salim.cascadetype.author.dto;

import lombok.Builder;

@Builder
public record AuthorResDto(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
