package com.cornielz.librarysystem.application.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import com.cornielz.librarysystem.domain.reservation.ReservationStatus;

public record ReservationCreationRequestDTO(
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotNull LocalDateTime borrowingDate,
        @NotNull LocalDateTime expectedReturnDate,
        LocalDateTime returnDate,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal appliedPrice,
        @NotNull ReservationStatus status
) {}