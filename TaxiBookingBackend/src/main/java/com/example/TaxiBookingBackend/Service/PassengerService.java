package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.PassengerDto;
import com.example.TaxiBookingBackend.Dto.TaxiDto;

import java.util.List;

public interface PassengerService {
    PassengerDto addPassenger(PassengerDto passengerDto);
    List<PassengerDto> getAllPassenger();
    void deletePassenger(Long id);
    PassengerDto getPassengerById(Long id);
}
