package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class ParkingSpots extends BaseModel{

    private int sportNumber;
    private int  floorNumber;
    private VehicleType vehicleType;
    private ParkingStatus spotStatus;


}
