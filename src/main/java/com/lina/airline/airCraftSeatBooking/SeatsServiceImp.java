package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.aircraft.AirCraftRepository;
import com.lina.airline.aircraft.AircraftEntity;

import com.lina.airline.exception.IllegalException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.lina.airline.enums.SeatType.BUSINESS;
import static com.lina.airline.enums.SeatType.ECONOMY;

@Service
@Slf4j
@AllArgsConstructor
public class SeatsServiceImp implements SeatsService{
    private final AirCraftRepository airCraftRepository;
    private final SeatsRepository seatsRepository;
    @Override
    public void createSeatsForAircraft(UUID aircraftId, int row, int column) {
       AircraftEntity aircraftEntity=airCraftRepository.findById(aircraftId).orElseThrow(() -> new  RuntimeException("Not found by id"));


        if(existByAircraftId(aircraftId)){
            throw new IllegalException( "AirCraft id already exist seats","001_001_00001");
        }

        List<SeatsEntity> seatsList=new ArrayList<>();
        for (char rowNumber = 'A'; rowNumber <= ('A'+row); rowNumber++) {
            for (int columnNumber =1; columnNumber<=column; columnNumber++) {
                if(columnNumber==3){
                    continue;
                }
                SeatsEntity seatsEntity=new SeatsEntity();
                seatsEntity.setSeatClass(rowNumber==3 || rowNumber>=5 ?ECONOMY:BUSINESS);
                seatsEntity.setSeatNumber(rowNumber + String.valueOf(columnNumber));
                seatsEntity.setRowNumber(rowNumber);
                seatsEntity.setColumnNumber(columnNumber);
                seatsEntity.setAircraftEntity(aircraftEntity);
                seatsEntity.setAvailable(true);
               seatsList.add(seatsEntity);

              log.info("Row {} column {}",rowNumber,columnNumber  );

            }

        }
        seatsRepository.saveAll(seatsList);
        System.out.println("Total seats created: " + seatsList.size());

    }

 public  boolean existByAircraftId(UUID aircraftId){
        return airCraftRepository.existsByAircraftId(aircraftId);
 }
}
