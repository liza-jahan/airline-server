package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.APIResponse;

import com.lina.airline.dto.request.SeatsRequest;
import com.lina.airline.dto.response.CreationResponse;
import com.lina.airline.dto.response.CreationResponseString;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class SeatsController {
    private final SeatsService seatsService;

    @PostMapping("/add-seats/{registrationNumber}")
    public ResponseEntity<APIResponse<CreationResponseString>> addSeatsForAircraft(@RequestBody @Valid SeatsRequest seatsRequest , @PathVariable String registrationNumber, @RequestParam int row, @RequestParam int colum){

          seatsService.createSeatsForAircraft(seatsRequest,registrationNumber,row,colum);
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
