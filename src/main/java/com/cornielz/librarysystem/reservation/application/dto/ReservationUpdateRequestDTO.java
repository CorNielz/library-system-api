package com.cornielz.librarysystem.reservation.application.dto;

import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationUpdateRequestDTO(
        UUID id,
        UUID userId,
        UUID bookId,
        LocalDateTime borrowingDate,
        LocalDateTime expectedReturnDate,
        LocalDateTime returnDate,
        @DecimalMin(value = "0.0", inclusive = false) BigDecimal appliedPrice,
        ReservationStatus status
) {
}