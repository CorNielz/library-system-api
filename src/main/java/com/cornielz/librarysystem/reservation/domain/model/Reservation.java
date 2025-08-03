package com.cornielz.librarysystem.domain.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Reservation {
    private final UUID id;

    private UUID userId;
    private UUID bookId;

    private LocalDateTime borrowingDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime returnDate;

    private BigDecimal appliedPrice;

    private ReservationStatus status;

    public Reservation(UUID id, UUID userId, UUID bookId, LocalDateTime borrowingDate, LocalDateTime expectedReturnDate, LocalDateTime returnDate, BigDecimal appliedPrice, ReservationStatus status) {
        this.id = id;

        this.userId = userId;
        this.bookId = bookId;

        this.borrowingDate = borrowingDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;

        this.appliedPrice = appliedPrice;

        this.status = status;
    }

    // Setters

    // Getters

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public LocalDateTime getBorrowingDate() {
        return borrowingDate;
    }

    public LocalDateTime getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public BigDecimal getAppliedPrice() {
        return appliedPrice;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}