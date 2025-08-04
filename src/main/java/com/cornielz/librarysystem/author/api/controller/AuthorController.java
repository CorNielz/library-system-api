package com.cornielz.librarysystem.author.api.controller;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.application.services.AuthorService;

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
        return ResponseEntity.ok(authorService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthor(@PathVariable UUID id) {
        return ResponseEntity.ok(authorService.getById(id));
        return ResponseEntity.ok(authorService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> listAuthors() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable UUID id) {
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}