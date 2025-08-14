package com.cornielz.librarysystem.reservation.application.dto;

import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationSearchFilters(
        UUID userId,
        UUID bookId,
        LocalDateTime borrowingDateFrom,
        LocalDateTime borrowingDateTo,
        LocalDateTime expectedReturnDateFrom,
        LocalDateTime expectedReturnDateTo,
        LocalDateTime returnDateFrom,
        LocalDateTime returnDateTo,
        BigDecimal appliedPriceMinimum,
        BigDecimal appliedPriceMaximum,
        ReservationStatus status
) {}