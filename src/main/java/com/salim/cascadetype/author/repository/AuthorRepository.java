package com.salim.cascadetype.author.repository;

import com.salim.cascadetype.author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
