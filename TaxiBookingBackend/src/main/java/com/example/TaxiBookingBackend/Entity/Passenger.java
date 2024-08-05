package com.example.TaxiBookingBackend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="passenger")
public class Passenger {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private  String passengerName;
    @Column(nullable = false)
    private Long contactNo;
    private int age;
    @Column(nullable = false)
    private Long pincode;
    @Column(name="JourneyCancelled")
    public boolean cancelStat;
//    @Column(name="JourneyStatus")
//    private boolean journeyStat;


}
