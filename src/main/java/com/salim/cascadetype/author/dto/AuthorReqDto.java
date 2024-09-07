package com.salim.cascadetype.author.dto;

import lombok.Builder;

@Builder
public record AuthorReqDto(
        String firstName,
        String lastName,
        String email
) {
}
