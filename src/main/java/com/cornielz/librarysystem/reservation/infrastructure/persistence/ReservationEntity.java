package com.cornielz.librarysystem.reservation.infrastructure.persistence;

import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "borrowing_date")
    private LocalDateTime borrowingDate;

    @Column(name = "expected_return_date")
    private LocalDateTime expectedReturnDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "applied_price", precision = 8, scale = 2, nullable = false)
    private BigDecimal appliedPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_update_at", nullable = false)
    private LocalDateTime lastUpdateAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.lastUpdateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdateAt = LocalDateTime.now();
    }

    public ReservationEntity() {

    }

    // Setters

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public void setBorrowingDate(LocalDateTime borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public void setExpectedReturnDate(LocalDateTime expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public void setAppliedPrice(BigDecimal appliedPrice) {
        this.appliedPrice = appliedPrice;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
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