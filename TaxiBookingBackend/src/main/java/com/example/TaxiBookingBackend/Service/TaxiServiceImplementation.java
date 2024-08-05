package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.TaxiDto;
import com.example.TaxiBookingBackend.Entity.Taxi;
import com.example.TaxiBookingBackend.Repository.TaxiRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaxiServiceImplementation implements TaxiService{
    private ModelMapper modelMapper;
    private TaxiRepository taxiRepository;
    @Override
    public TaxiDto addTaxi(TaxiDto taxiDto) {
        Taxi taxi=modelMapper.map(taxiDto, Taxi.class);
        Taxi savedTaxi=taxiRepository.save(taxi);
        return modelMapper.map(savedTaxi,TaxiDto.class);
    }

    @Override
    public List<TaxiDto> getAllTaxi() {
        List<Taxi> taxiList= taxiRepository.findAll();
        return taxiList.stream().map(taxi->modelMapper.map(taxi,TaxiDto.class)).collect(Collectors.toList());
    }

}
