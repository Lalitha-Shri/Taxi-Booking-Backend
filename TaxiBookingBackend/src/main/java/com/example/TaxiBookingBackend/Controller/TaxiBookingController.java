package com.example.TaxiBookingBackend.Controller;

import com.example.TaxiBookingBackend.Dto.PassengerDto;
import com.example.TaxiBookingBackend.Dto.TaxiBookingDto;
import com.example.TaxiBookingBackend.Entity.TaxiBooking;
import com.example.TaxiBookingBackend.Service.PassengerService;
import com.example.TaxiBookingBackend.Service.TaxiBookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/booking")
public class TaxiBookingController {
    @Autowired
    private TaxiBookingService bookingService;
    @PostMapping  //add booking details into repository
    public ResponseEntity<TaxiBookingDto> saveBook(@RequestBody TaxiBookingDto taxiBookingDto)
    {
        TaxiBookingDto savedBooking=bookingService.addBooking(taxiBookingDto);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }
}
