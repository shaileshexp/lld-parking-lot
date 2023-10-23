package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.Model.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class VehicleCreateRequest {
    private Vehicle vehicle;
    private LocalDateTime entryTime;


}
