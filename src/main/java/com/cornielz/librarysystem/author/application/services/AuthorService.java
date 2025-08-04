package com.cornielz.librarysystem.author.application.services;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    AuthorResponseDTO create(AuthorCreationRequestDTO request);
    AuthorResponseDTO update(AuthorUpdateRequestDTO request);
    void delete(UUID id);
    AuthorResponseDTO getById(UUID id);
    List<AuthorResponseDTO> listAll();
}