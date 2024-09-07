package com.salim.cascadetype.author.controller;

import com.salim.cascadetype.author.domain.Author;
import com.salim.cascadetype.author.dto.AuthorReqDto;
import com.salim.cascadetype.author.service.interfaces.AuthorService;
import com.salim.cascadetype.exception.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author/")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAuthors(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Find all authors")
                        .data(authorService.getAuthors(pageable))
                        .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getAuthorById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Find author by id")
                        .data(authorService.getAuthorById(id))
                        .build());
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updateAuthor(@PathVariable Long id, @RequestBody AuthorReqDto authorReqDto) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Update author")
                        .data(authorService.updateAuthor(id, authorReqDto))
                        .build());
    }
}
