package com.salim.cascadetype.author.service.impl;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.repository.AuthorRepository;
import com.salim.cascadetype.author.service.interfaces.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
