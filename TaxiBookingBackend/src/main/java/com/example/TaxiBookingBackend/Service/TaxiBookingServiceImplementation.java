package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.PassengerDto;
import com.example.TaxiBookingBackend.Dto.TaxiBookingDto;
import com.example.TaxiBookingBackend.Entity.Passenger;
import com.example.TaxiBookingBackend.Entity.TaxiBooking;
import com.example.TaxiBookingBackend.Repository.PassengerRepository;
import com.example.TaxiBookingBackend.Repository.TaxiBookingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaxiBookingServiceImplementation implements TaxiBookingService {
    private ModelMapper modelMapper;
    private TaxiBookingRepository bookingRepository;

    @Override
    public TaxiBookingDto addBooking(TaxiBookingDto bookingDto) {
        TaxiBooking booking=modelMapper.map(bookingDto, TaxiBooking.class);
        TaxiBooking savedBooking=bookingRepository.save(booking);
        return modelMapper.map(savedBooking, TaxiBookingDto.class);
    }
}
