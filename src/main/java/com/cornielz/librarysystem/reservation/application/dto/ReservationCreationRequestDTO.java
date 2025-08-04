package com.cornielz.librarysystem.reservation.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;

public record ReservationCreationRequestDTO(
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotNull LocalDateTime borrowingDate,
        @NotNull LocalDateTime expectedReturnDate,
        LocalDateTime returnDate,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal appliedPrice,
        @NotNull ReservationStatus status
) {}