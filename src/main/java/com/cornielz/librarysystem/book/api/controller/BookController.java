package com.cornielz.librarysystem.book.api.controller;

import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookSearchFilters;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;
import com.cornielz.librarysystem.book.application.services.BookService;
import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookCreationRequestDTO dto) {
        return ResponseEntity.ok(bookService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable UUID id, @Valid @RequestBody BookUpdateRequestDTO dto) {
        return ResponseEntity.ok(bookService.update(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable UUID id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<BookResponseDTO>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) LocalDateTime publicationDateFrom,
            @RequestParam(required = false) LocalDateTime publicationDateTo,
            @RequestParam(required = false) BigDecimal priceMinimum,
            @RequestParam(required = false) BigDecimal priceMaximum,
            @RequestParam(required = false) BookCondition condition,
            @RequestParam(required = false) BookStatus status
    ) {
        BookSearchFilters searchFilters = new BookSearchFilters(title, language, publicationDateFrom, publicationDateTo, priceMinimum, priceMaximum, condition, status);
        return ResponseEntity.ok(bookService.searchWithFilters(searchFilters));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}