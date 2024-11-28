package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.aircraft.AirCraftRepository;
import com.lina.airline.aircraft.AircraftEntity;
import com.lina.airline.dto.request.SeatsRequest;
import com.lina.airline.enums.SeatType;
import com.lina.airline.exception.IllegalException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class SeatsServiceImp implements SeatsService {
    private final AirCraftRepository airCraftRepository;
    private final SeatsRepository seatsRepository;

    private static final BigDecimal ECONOMIC_WINDOW_PRICE = new BigDecimal("1600.00");
    private static final BigDecimal ECONOMIC_AISLE_PRICE = new BigDecimal("1400.00");
    private static final BigDecimal ECONOMIC_CENTER_PRICE = new BigDecimal("1200.00");

    private static final BigDecimal BUSINESS_WINDOW_PRICE = new BigDecimal("1000.00");
    private static final BigDecimal BUSINESS_AISLE_PRICE = new BigDecimal("900.00");
    private static final BigDecimal BUSINESS_CENTER_PRICE = new BigDecimal("800.00");

    @Override
    public void createSeatsForAircraft(SeatsRequest seatsRequest, String registrationNumber, int row, int column) {
        AircraftEntity aircraftEntity = airCraftRepository.findByRegistrationNumber(registrationNumber).orElseThrow(() -> new RuntimeException("Not found by id"));


        if (areSeatsAlreadyCreated(registrationNumber)) {
            throw new IllegalException("AirCraft  already exist seats", "001_001_00001");
        }



        List<SeatsEntity> seatsList = new ArrayList<>();
        for (char rowNumber = 'A'; rowNumber <= ('A' + row); rowNumber++) {
            for (int columnNumber = 1; columnNumber <= column; columnNumber++) {
                if (rowNumber == 'A' && (columnNumber == 2 || columnNumber == 3)) {
                    continue;
                } else if (rowNumber >= 'B' && rowNumber <= 'H' && (columnNumber == 3)) {
                    continue;
                } else {
                    SeatsEntity seatsEntity = new SeatsEntity();
                    seatsEntity.setSeatClass(seatsRequest.getSeatClass());
                    seatsEntity.setSeatNumber(rowNumber + String.valueOf(columnNumber));
                    seatsEntity.setRowNumber(rowNumber);
                    seatsEntity.setColumnNumber(columnNumber);
                    seatsEntity.setAircraftEntity(aircraftEntity);

                    String seatClass = seatsRequest.getSeatClass() != null
                            ? seatsRequest.getSeatClass().toUpperCase()
                            : null;

                    if (SeatType.ECONOMY.name().equalsIgnoreCase(seatClass)) {
                        if ((columnNumber == 1 || columnNumber == column)) {
                            seatsEntity.setPrice(ECONOMIC_WINDOW_PRICE);
                        } else if (columnNumber == 2 || columnNumber == (column - 1)) {
                            seatsEntity.setPrice(ECONOMIC_AISLE_PRICE);
                        } else {
                            seatsEntity.setPrice(ECONOMIC_CENTER_PRICE);
                        }
                    } else if (SeatType.BUSINESS.name().equalsIgnoreCase(seatClass)) {
                        if ((columnNumber == 1 || columnNumber == column)) {
                            seatsEntity.setPrice(BUSINESS_WINDOW_PRICE);
                        } else if (columnNumber == 2 || columnNumber == (column - 1)) {
                            seatsEntity.setPrice(BUSINESS_AISLE_PRICE);
                        } else {
                            seatsEntity.setPrice(BUSINESS_CENTER_PRICE);
                        }
                    }
                    seatsEntity.setAvailable(true);
                    seatsList.add(seatsEntity);

                    log.info("Row {} column {}", rowNumber, columnNumber);

                }
            }
        }
        seatsRepository.saveAll(seatsList);
    }

    public boolean areSeatsAlreadyCreated(String registrationNumber) {
        return seatsRepository.existsByAircraftEntityRegistrationNumber(registrationNumber);
    }

    //public boolean findBySeatNumberAndAircraftId(String seatNumber, UUID aircraftId) {
   //     return seatsRepository.findBySeatNumberAndAircraftId(seatNumber,aircraftId);}
}
