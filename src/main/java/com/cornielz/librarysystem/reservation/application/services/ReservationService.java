package com.cornielz.librarysystem.reservation.application.services;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationReplaceRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationSearchFilters;

import java.util.List;
import java.util.UUID;

public interface ReservationService {
    ReservationResponseDTO create(ReservationCreationRequestDTO requestDto);

    ReservationResponseDTO replace(UUID id, ReservationReplaceRequestDTO requestDto);

    ReservationResponseDTO update(UUID id, ReservationUpdateRequestDTO requestDto);

    void delete(UUID id);

    ReservationResponseDTO getById(UUID id);

    List<ReservationResponseDTO> searchWithFilters(ReservationSearchFilters searchFilters);
}
