package com.example.TaxiBookingBackend.Repository;

import com.example.TaxiBookingBackend.Entity.TaxiBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiBookingRepository extends JpaRepository<TaxiBooking, Long> {
}
