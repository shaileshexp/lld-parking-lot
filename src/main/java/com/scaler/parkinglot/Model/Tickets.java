package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@Setter
@Getter
public class Tickets extends BaseModel{
    private int vehicleNumber;
    private int spotNumber;
    private int  gateId;
    private Date entryTime;
    private int parkingAttendants;
    private int floorNumber;
    private List<ParkingSpots> parkingSpotsList;

}
