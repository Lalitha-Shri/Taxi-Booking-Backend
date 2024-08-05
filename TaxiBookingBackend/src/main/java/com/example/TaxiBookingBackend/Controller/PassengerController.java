package com.example.TaxiBookingBackend.Controller;

import com.example.TaxiBookingBackend.Dto.PassengerDto;
import com.example.TaxiBookingBackend.Dto.TaxiDto;
import com.example.TaxiBookingBackend.Service.PassengerService;
import com.example.TaxiBookingBackend.Service.TaxiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    @PostMapping  //add passenger into repository
    public ResponseEntity<PassengerDto> savePassenger(@RequestBody PassengerDto passengerDto)
    {
        PassengerDto savedPassenger=passengerService.addPassenger(passengerDto);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }
    @GetMapping  //get all passenger from repository in a list
    public ResponseEntity<List<PassengerDto>> getAllPassenger()
    {
        List<PassengerDto> allPassenger=passengerService.getAllPassenger();
        return new ResponseEntity<List<PassengerDto>>(allPassenger,HttpStatus.OK);
    }
    @DeleteMapping("/{id}") //delete passenger by id
    public  String deleteUser(@PathVariable("id")Long userId)
    {
        passengerService.deletePassenger(userId);
        return "Passenger is deleted";
    }
    @GetMapping("/{Id}") //get passenger details by id
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable("Id")Long id)
    {
        PassengerDto getPassenger=passengerService.getPassengerById(id);
        return new ResponseEntity<PassengerDto>(getPassenger,HttpStatus.OK);
    }
}
