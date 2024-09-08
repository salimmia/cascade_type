package com.salim.cascadetype.author.service.impl;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.dto.AuthorReqDto;
import com.salim.cascadetype.author.dto.AuthorResDto;
import com.salim.cascadetype.author.mapper.AuthorMapper;
import com.salim.cascadetype.author.repository.AuthorRepository;
import com.salim.cascadetype.author.service.interfaces.AuthorService;
import com.salim.cascadetype.util.FieldDifferentUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public Page<AuthorResDto> getAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable)
                .map(authorMapper::toDto);
    }

    @Override
    public Optional<AuthorResDto> getAuthorById(Long id) {
        return Optional.ofNullable(authorRepository.findById(id)
                .map(authorMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Author not found")));
    }

    @Override
    public Optional<AuthorResDto> updateAuthor(Long id, AuthorReqDto authorReqDto) {
        Author dbAuthor = authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (FieldDifferentUtil.isDifferent(authorReqDto.firstName(), dbAuthor.getFirstName())) {
            dbAuthor.setFirstName(authorReqDto.firstName());
        }
        if (FieldDifferentUtil.isDifferent(authorReqDto.lastName(), dbAuthor.getLastName())) {
            dbAuthor.setLastName(authorReqDto.lastName());
        }
        if (FieldDifferentUtil.isDifferent(authorReqDto.email(), dbAuthor.getEmail())) {
            dbAuthor.setEmail(authorReqDto.email());
        }

        return Optional.ofNullable(Optional.of(authorMapper.toDto(authorRepository.save(dbAuthor)))
                .orElseThrow(() -> new EntityNotFoundException("Entity not found")));
    }
}
