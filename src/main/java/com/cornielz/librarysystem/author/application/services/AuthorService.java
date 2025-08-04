package com.cornielz.librarysystem.author.application.services;

import java.util.List;
import java.util.UUID;
import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;

public interface AuthorService {
    AuthorResponseDTO create(AuthorCreationRequestDTO request);
    AuthorResponseDTO update(AuthorUpdateRequestDTO request);
    void delete(UUID id);
    AuthorResponseDTO getById(UUID id);
    List<AuthorResponseDTO> listAll();
}