package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class ParkingFloor extends BaseModel{

    private int floorNumber;
    private List<ParkingSpots> parkingSpotsList = new ArrayList<>();

    private DisplayBoards displayBoards;

}
