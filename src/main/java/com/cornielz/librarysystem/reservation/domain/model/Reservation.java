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

    public void changeUser(UUID newUserId){
        this.userId = newUserId;
    }

    public void changeBook(UUID newBookId){
        this.bookId = newBookId;
    }

    public void updateBorrowingDate(LocalDateTime newBorrowingDate){
        this.borrowingDate = newBorrowingDate;
    }

    public void updateExpectedReturnDate(LocalDateTime newExpectedReturnDate){
        this.expectedReturnDate = newExpectedReturnDate;
    }

    public void updateReturnDate(LocalDateTime newReturnDate){
        this.returnDate = newReturnDate;
    }

    public void modifyAppliedPrice(BigDecimal newAppliedPrice){
        this.appliedPrice = newAppliedPrice;
    }

    public void updateReservationStatus(ReservationStatus newReservationStatus){
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