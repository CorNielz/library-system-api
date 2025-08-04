package com.cornielz.librarysystem.reservation.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import com.cornielz.librarysystem.domain.reservation.ReservationStatus;

public record ReservationResponseDTO(
        UUID id,
        UUID userId,
        UUID bookId,
        LocalDateTime borrowingDate,
        LocalDateTime expectedReturnDate,
        LocalDateTime returnDate,
        BigDecimal appliedPrice,
        ReservationStatus status
) {}