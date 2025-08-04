package com.cornielz.librarysystem.reservation.application.dto;

import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationCreationRequestDTO(
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotNull LocalDateTime borrowingDate,
        @NotNull LocalDateTime expectedReturnDate,
        LocalDateTime returnDate,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal appliedPrice,
        @NotNull ReservationStatus status
) {
}