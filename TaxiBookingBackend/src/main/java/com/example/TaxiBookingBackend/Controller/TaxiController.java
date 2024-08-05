package com.example.TaxiBookingBackend.Controller;

import com.example.TaxiBookingBackend.Dto.TaxiDto;
import com.example.TaxiBookingBackend.Repository.TaxiRepository;
import com.example.TaxiBookingBackend.Service.TaxiService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/taxi")
public class TaxiController {
    @Autowired
    private TaxiService taxiService;
    @Autowired
    private TaxiRepository taxiRepository;

    @PostMapping
    public ResponseEntity<TaxiDto> saveTaxi(@RequestBody TaxiDto taxiDto)
    {
        TaxiDto savedTaxi=taxiService.addTaxi(taxiDto);
        return new ResponseEntity<>(savedTaxi, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TaxiDto>> getAllTaxis()
    {
        List<TaxiDto> allTaxi=taxiService.getAllTaxi();
        return new ResponseEntity<List<TaxiDto>>(allTaxi,HttpStatus.OK);
    }

}
