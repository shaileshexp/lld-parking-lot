package com.scaler.parkinglot.Model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@SuperBuilder
@Getter
@Setter
public class ParkingLot extends BaseModel{

    private String name;
    private String address;

    private List<ParkingFloor> parkingFloorList = new ArrayList<>();

    private List<EntryGates> entryGatesList = new ArrayList<>();

    private List<ExitGates> exitGatesList = new ArrayList<>();

    private DisplayBoards displayBoard;


    public Tickets createEntry(Vehicle v){

        return Tickets.builder().build();
    }



}
