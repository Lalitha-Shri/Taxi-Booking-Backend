package com.example.TaxiBookingBackend.Dto;

import com.example.TaxiBookingBackend.Entity.Passenger;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;

public class TaxiBookingDto {

    private Long id;

    private Passenger passenger;
    private String taxiName;
    private int fee;

    private LocalDate departureDate;
}
