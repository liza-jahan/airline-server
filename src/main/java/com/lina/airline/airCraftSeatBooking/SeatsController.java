package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.APIResponse;

import com.lina.airline.dto.response.CreationResponse;
import com.lina.airline.dto.response.CreationResponseString;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class SeatsController {
    private final SeatsService seatsService;

    @PostMapping("/add-seats")
    public ResponseEntity<APIResponse<CreationResponseString>> addSeatsForAircraft(@RequestParam UUID airCraftId, @RequestParam int row, @RequestParam int colum){
          seatsService.createSeatsForAircraft(airCraftId,row,colum);
        APIResponse<CreationResponseString> responseDTO = APIResponse
                .<CreationResponseString>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
               .results(new CreationResponseString("seats added successfully!"))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

}
