package com.lina.airline.airCraftSeatBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SeatsRepository extends JpaRepository<SeatsEntity,Integer> {
  //  List<SeatsRepository> findByAircraftIdAndIsAvailable(UUID aircraftId, boolean isAvailable);
}
