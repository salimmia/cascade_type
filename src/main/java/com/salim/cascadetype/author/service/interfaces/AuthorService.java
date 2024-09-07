package com.salim.cascadetype.author.service.interfaces;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.dto.AuthorReqDto;
import com.salim.cascadetype.author.dto.AuthorResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
    Page<Author> getAuthors(Pageable pageable);
    AuthorResDto getAuthorById(Long id);
    AuthorResDto updateAuthor(Long id, AuthorReqDto authorReqDto);
}
