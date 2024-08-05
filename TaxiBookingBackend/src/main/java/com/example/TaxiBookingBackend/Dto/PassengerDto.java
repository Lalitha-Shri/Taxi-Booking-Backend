package com.example.TaxiBookingBackend.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
    private Long Id;
    private  String passengerName;
    private Long contactNo;
    private int age;
    private Long pincode;
    public boolean cancelStat;

}
