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
            "(reservation.userId = :userId OR :userId IS NULL) AND " +
            "(reservation.bookId = :bookId OR :bookId IS NULL) AND " +
            "(reservation.borrowingDate >= :borrowingDateFrom OR CAST(:borrowingDateFrom AS date) IS NULL) AND " +
            "(reservation.borrowingDate <= :borrowingDateTo OR CAST(:borrowingDateTo AS date) IS NULL) AND " +
            "(reservation.expectedReturnDate >= :expectedReturnDateFrom OR CAST(:expectedReturnDateFrom AS date) IS NULL) AND " +
            "(reservation.expectedReturnDate <= :expectedReturnDateTo OR CAST(:expectedReturnDateTo AS date) IS NULL) AND " +
            "(reservation.returnDate >= :returnDateFrom OR CAST(:returnDateFrom AS date) IS NULL) AND " +
            "(reservation.returnDate <= :returnDateTo OR CAST(:returnDateTo AS date) IS NULL) AND " +
            "(reservation.appliedPrice >= :appliedPriceMinimum OR :appliedPriceMinimum IS NULL) AND " +
            "(reservation.appliedPrice <= :appliedPriceMaximum OR :appliedPriceMaximum IS NULL) AND " +
            "(CAST(reservation.status AS string) = CAST(:status AS string) OR :status IS NULL)")
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