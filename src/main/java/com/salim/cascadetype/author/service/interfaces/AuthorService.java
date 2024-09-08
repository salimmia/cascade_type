package com.salim.cascadetype.author.service.interfaces;

import com.salim.cascadetype.author.dto.AuthorReqDto;
import com.salim.cascadetype.author.dto.AuthorResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorService {
    Page<AuthorResDto> getAuthors(Pageable pageable);
    Optional<AuthorResDto> getAuthorById(Long id);
    Optional<AuthorResDto> updateAuthor(Long id, AuthorReqDto authorReqDto);
}
