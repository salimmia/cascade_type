package com.salim.cascadetype.author.mapper;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.dto.AuthorReqDto;
import com.salim.cascadetype.author.dto.AuthorResDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toEntity(AuthorReqDto authorReqDto) {
        return Author.builder()
                .firstName(authorReqDto.firstName())
                .lastName(authorReqDto.lastName())
                .email(authorReqDto.email())
                .build();
    }

    public AuthorResDto toDto(Author author) {
        return AuthorResDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .email(author.getEmail())
                .build();
    }
}
