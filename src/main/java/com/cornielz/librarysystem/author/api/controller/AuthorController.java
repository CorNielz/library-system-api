package com.cornielz.librarysystem.author.api.controller;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.application.services.AuthorService;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(@Valid @RequestBody AuthorCreationRequestDTO dto) {
        return ResponseEntity.ok(authorService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable UUID id, @Valid @RequestBody AuthorUpdateRequestDTO dto) {
        return ResponseEntity.ok(authorService.update(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthor(@PathVariable UUID id) {
        return ResponseEntity.ok(authorService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<AuthorResponseDTO>> searchAuthors(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String nationality,
        @RequestParam(required = false) LocalDateTime birthDateFrom,
        @RequestParam(required = false) LocalDateTime birthDateTo,
        @RequestParam(required = false) AuthorStatus status
    ) {
        AuthorSearchFilters searchFilters = new AuthorSearchFilters(name, birthDateFrom, birthDateTo, nationality, status);
        return ResponseEntity.ok(authorService.searchWithFilters(searchFilters));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable UUID id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}