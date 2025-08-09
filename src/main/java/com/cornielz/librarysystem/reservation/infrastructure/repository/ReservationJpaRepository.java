package com.cornielz.librarysystem.reservation.infrastructure.repository;

import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;
import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, UUID> {
    @Query("SELECT reservation FROM ReservationEntity reservation WHERE " +
            "(:userId IS NULL OR reservation.user.id = :userId) AND " +
            "(:bookId IS NULL OR reservation.book.id = :bookId) AND " +
            "(:borrowingDateFrom IS NULL OR reservation.borrowingDate >= :borrowingDateFrom) AND " +
            "(:borrowingDateTo IS NULL OR reservation.borrowingDate <= :borrowingDateTo) AND " +
            "(:expectedReturnDateFrom IS NULL OR reservation.expectedReturnDate >= :expectedReturnDateFrom) AND " +
            "(:expectedReturnDateTo IS NULL OR reservation.expectedReturnDate <= :expectedReturnDateTo) AND " +
            "(:returnDateFrom IS NULL OR reservation.returnDate >= :returnDateFrom) AND " +
            "(:returnDateTo IS NULL OR reservation.returnDate <= :returnDateTo) AND " +
            "(:appliedPriceMinimum IS NULL OR reservation.appliedPrice >= :appliedPriceMinimum) AND " +
            "(:appliedPriceMaximum IS NULL OR reservation.appliedPrice <= :appliedPriceMaximum) AND " +
            "(:status IS NULL OR reservation.status = :status)")
    Optional<List<ReservationEntity>> findAllFiltered(
            @Param("userId") UUID userId,
            @Param("bookId") UUID bookId,
            @Param("borrowingDateFrom") LocalDateTime borrowingDateFrom,
            @Param("borrowingDateTo") LocalDateTime borrowingDateTo,
            @Param("expectedReturnDateFrom") LocalDateTime expectedReturnDateFrom,
            @Param("expectedReturnDateTo") LocalDateTime expectedReturnDateTo,
            @Param("returnDateFrom") LocalDateTime returnDateFrom,
            @Param("returnDateTo") LocalDateTime returnDateTo,
            @Param("appliedPriceMinimum") BigDecimal appliedPriceMinimum,
            @Param("appliedPriceMaximum") BigDecimal appliedPriceMaximum,
            @Param("status") ReservationStatus status
    );
}