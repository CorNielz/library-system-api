package com.cornielz.librarysystem.reservation.infrastructure.persistence;

import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.domain.repository.ReservationRepository;
import com.cornielz.librarysystem.reservation.infrastructure.mapper.ReservationEntityMapper;
import com.cornielz.librarysystem.reservation.infrastructure.repository.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {

    private final ReservationJpaRepository jpaRepository;
    private final ReservationEntityMapper mapper;

    @Override
    public Optional<Reservation> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Reservation> findAllByUserId(UUID userId) {
        return jpaRepository.findAllByUserId(userId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findAllByBookId(UUID bookId) {
        return jpaRepository.findAllByBookId(bookId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Reservation reservation) {
        jpaRepository.save(mapper.toEntity(reservation));
    }

    @Override
    public void delete(UUID id) {
        jpaRepository.deleteById(id);
    }
}