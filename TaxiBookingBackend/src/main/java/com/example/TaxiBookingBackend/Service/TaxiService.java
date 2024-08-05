package com.example.TaxiBookingBackend.Service;

import com.example.TaxiBookingBackend.Dto.TaxiDto;

import java.util.List;

public interface TaxiService
{
    TaxiDto addTaxi(TaxiDto taxiDto);
    List<TaxiDto> getAllTaxi();
    TaxiDto getTaxiById(Long id);
    void deleteTaxi(Long id);
    TaxiDto updateTaxis(TaxiDto taxiDto, Long id);
}
