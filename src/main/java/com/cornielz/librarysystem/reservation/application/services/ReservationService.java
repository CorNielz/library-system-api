package com.cornielz.librarysystem.reservation.application.services;

import java.util.List;
import java.util.UUID;

public interface ReservationService {
    ReservationResponseDTO create(ReservationCreationRequestDTO request);
    ReservationResponseDTO update(ReservationUpdateRequestDTO request);
    void delete(UUID id);
    ReservationResponseDTO getById(UUID id);
    List<ReservationResponseDTO> listAll();
    List<ReservationResponseDTO> listByUserId(UUID userId);
    List<ReservationResponseDTO> listByBookId(UUID bookId);
}
