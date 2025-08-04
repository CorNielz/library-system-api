package com.cornielz.librarysystem.application.author;

import com.cornielz.librarysystem.domain.author.Author;
import com.cornielz.librarysystem.domain.author.AuthorRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuthorResponseDTO create(AuthorCreationRequestDTO dto) {
        Author author = new Author(UUID.randomUUID(), dto.name(), dto.bio(), dto.birthDate(), dto.nationality(), dto.status());
        repository.save(author);
        return toDTO(author);
    }

    @Override
    public AuthorResponseDTO update(AuthorUpdateRequestDTO dto) {
        Author author = repository.findById(dto.id()).orElseThrow();
        author.update(dto.name(), dto.bio(), dto.birthDate(), dto.nationality(), dto.status());
        repository.save(author);
        return toDTO(author);
    }

    @Override
    public void delete(UUID id) {
        repository.markAsDeleted(id);
    }

    @Override
    public AuthorResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<AuthorResponseDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private AuthorResponseDTO toDTO(Author author) {
        return new AuthorResponseDTO(author.id(), author.name(), author.bio(), author.birthDate(), author.nationality(), author.status());
    }
}
