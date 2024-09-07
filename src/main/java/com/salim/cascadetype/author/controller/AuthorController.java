package com.salim.cascadetype.author.controller;

import com.salim.cascadetype.author.service.interfaces.AuthorService;
import com.salim.cascadetype.exception.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author/")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAuthors() {
        return ResponseEntity
                .ok()
                .body(ApiResponse.builder()
                        .success(true)
                        .message("Find all authors")
                        .data(authorService.getAuthors())
                        .build());
    }
}
