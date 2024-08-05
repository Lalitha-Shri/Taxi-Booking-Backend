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

    @PostMapping //save taxi into repository done only by admin
    public ResponseEntity<TaxiDto> saveTaxi(@RequestBody TaxiDto taxiDto)
    {
        TaxiDto savedTaxi=taxiService.addTaxi(taxiDto);
        return new ResponseEntity<>(savedTaxi, HttpStatus.CREATED);
    }
    @GetMapping //get all taxis from repository in a list
    public ResponseEntity<List<TaxiDto>> getAllTaxis()
    {
        List<TaxiDto> allTaxi=taxiService.getAllTaxi();
        return new ResponseEntity<List<TaxiDto>>(allTaxi,HttpStatus.OK);
    }
    @GetMapping("/{taxiId}") //get Taxi details by id
    public ResponseEntity<TaxiDto> getTaxiById(@PathVariable("taxiId")Long taxiIds)
    {
        TaxiDto getTaxi=taxiService.getTaxiById(taxiIds);
        return new ResponseEntity<TaxiDto>(getTaxi,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")//delete taxi by Id
    public  String deleteTaxi(@PathVariable("id")Long taxiId)
    {
        taxiService.deleteTaxi(taxiId);
        return "Taxi is deleted";
    }
    @PutMapping("/{id}")//update taxi details by id
    public ResponseEntity<TaxiDto> updateTaxi(@PathVariable("id") Long id, @RequestBody TaxiDto taxiDto)
    {
        TaxiDto updatedTaxi=taxiService.updateTaxis(taxiDto,id);
        return new ResponseEntity<>(updatedTaxi, HttpStatus.OK);
    }
}
