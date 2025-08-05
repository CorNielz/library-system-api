package com.cornielz.librarysystem.reservation.application.dto;

import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationResponseDTO(
        UUID id,
        UUID userId,
        UUID bookId,
        LocalDateTime borrowingDate,
        LocalDateTime expectedReturnDate,
        LocalDateTime returnDate,
        BigDecimal appliedPrice,
        ReservationStatus status
) {
}