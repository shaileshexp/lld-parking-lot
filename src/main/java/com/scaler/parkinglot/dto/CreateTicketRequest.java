package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.Model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateTicketRequest {
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private int entryGateNumber;
    private int parkingAttendant;


}
