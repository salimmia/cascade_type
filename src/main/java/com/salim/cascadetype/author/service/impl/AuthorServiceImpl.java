package com.salim.cascadetype.author.service.impl;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.dto.AuthorReqDto;
import com.salim.cascadetype.author.dto.AuthorResDto;
import com.salim.cascadetype.author.mapper.AuthorMapper;
import com.salim.cascadetype.author.repository.AuthorRepository;
import com.salim.cascadetype.author.service.interfaces.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public Page<Author> getAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public AuthorResDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return null;
        }
        return authorMapper.toDto(author);
    }

    @Override
    public AuthorResDto updateAuthor(Long id, AuthorReqDto authorReqDto) {
        Author author = authorMapper.toEntity(authorReqDto);
        author.setId(id);
        Author dbAuthor = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author not found"));

        if (authorReqDto.firstName() != null && !Objects.equals(authorReqDto.lastName(), dbAuthor.getFirstName())) {
            author.setFirstName(authorReqDto.firstName());
        }
        if (authorReqDto.lastName() != null && !Objects.equals(authorReqDto.lastName(), dbAuthor.getLastName())) {
            author.setLastName(authorReqDto.lastName());
        }
        if (authorReqDto.email() != null && !Objects.equals(authorReqDto.email(), dbAuthor.getEmail())) {
            author.setEmail(authorReqDto.email());
        }

        return authorMapper.toDto(authorRepository.save(author));
    }
}
