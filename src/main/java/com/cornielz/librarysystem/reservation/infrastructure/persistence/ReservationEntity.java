package com.cornielz.librarysystem.infrastructure.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import jakarta.persistence.*;
import com.cornielz.librarysystem.domain.reservation.ReservationStatus;
import com.cornielz.librarysystem.infrastructure.book.BookEntity;
import com.cornielz.librarysystem.infrastructure.user.UserEntity;

@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

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

    protected ReservationEntity() {

    }

    // Setters

    public void changeUser(UserEntity newUser){
        this.user = newUser;
    }

    public void changeBook(BookEntity newBook){
        this.book = newBook;
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

    public UserEntity getUser() {
        return user;
    }

    public BookEntity getBook() {
        return book;
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