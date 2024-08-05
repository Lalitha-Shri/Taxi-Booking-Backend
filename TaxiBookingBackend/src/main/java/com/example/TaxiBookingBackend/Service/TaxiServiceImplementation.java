package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.TaxiDto;
import com.example.TaxiBookingBackend.Entity.Taxi;
import com.example.TaxiBookingBackend.Repository.TaxiRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public TaxiDto getTaxiById(Long id) {
        Taxi taxi = taxiRepository.findById(id).get();
        return modelMapper.map(taxi,TaxiDto.class);
    }

    @Override
    public void deleteTaxi(Long id) {
        Taxi taxi=taxiRepository.findById(id).get();
        taxiRepository.delete(taxi);
    }

    @Override
    public TaxiDto updateTaxis(TaxiDto taxiDto, Long id) {
        Taxi taxi= taxiRepository.findById(id).get();
        taxi.setTaxiName(taxiDto.getTaxiName());
        taxi.setPickupLocation(taxiDto.getPickupLocation());
        taxi.setDropLocation(taxiDto.getDropLocation());
        taxi.setPrice(taxiDto.getPrice());
        taxi.setTimeSlot(taxiDto.getTimeSlot());
        taxi.setDate(taxiDto.getDate());

        Taxi updated=taxiRepository.save(taxi);
        return modelMapper.map(updated,TaxiDto.class);
    }


}
