package com.lina.airline.airCraftSeatBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SeatsRepository extends JpaRepository<SeatsEntity,Integer> {
   @Query(value = "SELECT * FROM seatdetails WHERE id = :id AND is_available = :isAvailable", nativeQuery = true)
   Optional<SeatsEntity> findByIdAndIsAvailable(@Param("id") int id, @Param("isAvailable") boolean isAvailable);



}
