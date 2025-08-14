package com.cornielz.librarysystem.author.application.services;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorReplaceRequestDTO;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    AuthorResponseDTO create(AuthorCreationRequestDTO requestDto);

    AuthorResponseDTO replace(UUID id, AuthorReplaceRequestDTO requestDto);

    AuthorResponseDTO update(UUID id, AuthorUpdateRequestDTO requestDto);

    void delete(UUID id);

    AuthorResponseDTO getById(UUID id);

    List<AuthorResponseDTO> searchWithFilters(AuthorSearchFilters searchFilters);
}