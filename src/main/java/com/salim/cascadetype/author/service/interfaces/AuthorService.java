package com.salim.cascadetype.author.service.interfaces;

import com.salim.cascadetype.author.domain.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
}
