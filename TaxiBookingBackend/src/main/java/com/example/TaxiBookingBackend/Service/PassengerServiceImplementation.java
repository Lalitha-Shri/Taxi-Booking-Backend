package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.PassengerDto;
import com.example.TaxiBookingBackend.Dto.TaxiDto;
import com.example.TaxiBookingBackend.Entity.Passenger;
import com.example.TaxiBookingBackend.Entity.Taxi;
import com.example.TaxiBookingBackend.Repository.PassengerRepository;
import com.example.TaxiBookingBackend.Repository.TaxiRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PassengerServiceImplementation implements PassengerService {

    private ModelMapper modelMapper;
    private PassengerRepository passengerRepository;
    @Override
    public PassengerDto addPassenger(PassengerDto passengerDto) {
        Passenger passenger=modelMapper.map(passengerDto, Passenger.class);
        Passenger savedPassenger=passengerRepository.save(passenger);
        return modelMapper.map(savedPassenger, PassengerDto.class);
    }

    @Override
    public List<PassengerDto> getAllPassenger() {
        List<Passenger> passengerList= passengerRepository.findAll();
        return passengerList.stream().map(passenger->modelMapper.map(passenger,PassengerDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deletePassenger(Long id) {
        Passenger passenger=passengerRepository.findById(id).get();
        passengerRepository.delete(passenger);
    }

    @Override
    public PassengerDto getPassengerById(Long id) {
        Passenger passenger=passengerRepository.findById(id).get();
        return modelMapper.map(passenger,PassengerDto.class);
    }
}
