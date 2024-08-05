package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.PassengerDto;
import com.example.TaxiBookingBackend.Dto.TaxiBookingDto;
import com.example.TaxiBookingBackend.Entity.TaxiBooking;

public interface TaxiBookingService {
    TaxiBookingDto addBooking(TaxiBookingDto bookingDto);
}
