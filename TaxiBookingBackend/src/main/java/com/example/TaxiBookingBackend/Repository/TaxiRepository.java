package com.example.TaxiBookingBackend.Repository;

import com.example.TaxiBookingBackend.Dto.TaxiDto;
import com.example.TaxiBookingBackend.Entity.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi,Long> {

}
