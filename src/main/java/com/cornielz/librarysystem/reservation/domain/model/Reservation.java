package com.cornielz.librarysystem.reservation.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Reservation {
    private static final int MAX_PRICE_PRECISION = 8;
    private static final int MAX_PRICE_SCALE = 2;

    private final UUID id;

    private UUID userId;
    private UUID bookId;

    private LocalDateTime borrowingDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime returnDate;

    private BigDecimal appliedPrice;

    private ReservationStatus status;

    public Reservation(UUID id, UUID userId, UUID bookId, LocalDateTime borrowingDate, LocalDateTime expectedReturnDate, LocalDateTime returnDate, BigDecimal appliedPrice, ReservationStatus status) {
        validateId(id);
        validateId(userId);
        validateId(bookId);
        validateBorrowingDate(borrowingDate);
        validateExpectedReturnDate(expectedReturnDate, borrowingDate);
        validateReturnDate(returnDate, borrowingDate);
        validateAppliedPrice(appliedPrice);
        validateStatus(status);

        this.id = id;

        this.userId = userId;
        this.bookId = bookId;

        this.borrowingDate = borrowingDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;

        this.appliedPrice = appliedPrice;

        this.status = status;
    }

    private void validateId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    private void validateBorrowingDate(LocalDateTime borrowingDate) {
        if (borrowingDate == null) {
            throw new IllegalArgumentException("Borrowing date cannot be null");
        }

        LocalDateTime currentMoment = LocalDateTime.now();

        if (borrowingDate.isAfter(currentMoment)) {
            throw new IllegalArgumentException("Borrowing date cannot be in the future");
        }
    }

    private void validateExpectedReturnDate(LocalDateTime expectedReturnDate, LocalDateTime borrowingDate) {
        if (expectedReturnDate == null) {
            throw new IllegalArgumentException("Expected return date cannot be null");
        }

        if (expectedReturnDate.isBefore(borrowingDate)) {
            throw new IllegalArgumentException("Return date cannot be before borrowing date");
        }
    }

    private void validateReturnDate(LocalDateTime returnDate, LocalDateTime borrowingDate) {
        if (returnDate == null) {
            return;
        }
        
        if (returnDate.isBefore(borrowingDate)) {
            throw new IllegalArgumentException("Return date cannot be before borrowing date");
        }
    }

    private void validateAppliedPrice(BigDecimal appliedPrice) {
        if (appliedPrice == null) {
            throw new IllegalArgumentException("Applied price cannot be null");
        }

        if (appliedPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Applied price cannot be negative");
        }

        if (appliedPrice.scale() > MAX_PRICE_SCALE) {
            throw new IllegalArgumentException(String.format("Applied price cannot have more than %s decimal places", MAX_PRICE_SCALE));
        }

        if (appliedPrice.precision() > MAX_PRICE_PRECISION) {
            throw new IllegalArgumentException(String.format("Applied price cannot exceed %s total digits", MAX_PRICE_PRECISION));
        }
    }

    private void validateStatus(ReservationStatus status){
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    // Setters

    public void changeUser(UUID newUserId){
        validateId(newUserId);
        this.userId = newUserId;
    }

    public void changeBook(UUID newBookId){
        validateId(newBookId);
        this.bookId = newBookId;
    }

    public void updateBorrowingDate(LocalDateTime newBorrowingDate){
        validateBorrowingDate(newBorrowingDate);
        this.borrowingDate = newBorrowingDate;
    }

    public void updateExpectedReturnDate(LocalDateTime newExpectedReturnDate){
        validateExpectedReturnDate(newExpectedReturnDate, this.borrowingDate);
        this.expectedReturnDate = newExpectedReturnDate;
    }

    public void updateReturnDate(LocalDateTime newReturnDate){
        validateReturnDate(newReturnDate, this.borrowingDate);
        this.returnDate = newReturnDate;
    }

    public void modifyAppliedPrice(BigDecimal newAppliedPrice){
        validateAppliedPrice(newAppliedPrice);
        this.appliedPrice = newAppliedPrice;
    }

    public void updateReservationStatus(ReservationStatus newReservationStatus){
        validateStatus(newReservationStatus);
        this.status = newReservationStatus;
    }

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