package com.scaler.parkinglot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.scaler.parkinglot.Model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class ParkingLotRequest {
    private int totalFloor;
    private int totalSlotPerFloor;
    private String name;
    private String address;

    private  List<ParkingSpots> createParkingSpots(int floorNumber) {

        List<ParkingSpots> parkingSpots = new ArrayList<>();

        for (int i = 0; i < totalSlotPerFloor; i++) {
            int spotNumber = i+1;
            if(spotNumber == 1){
                parkingSpots.add(ParkingSpots.builder().floorNumber(floorNumber).sportNumber(spotNumber).vehicleType(VehicleType.SMALL).spotStatus(ParkingStatus.FREE).build());
            } else if (spotNumber == 2) {
                parkingSpots.add(ParkingSpots.builder().floorNumber(floorNumber).sportNumber(spotNumber).vehicleType(VehicleType.MEDIUM).spotStatus(ParkingStatus.FREE).build());
            } else {
                parkingSpots.add(ParkingSpots.builder().floorNumber(floorNumber).sportNumber(spotNumber).vehicleType(VehicleType.LARGE).spotStatus(ParkingStatus.FREE).build());
            }
        }
        return parkingSpots;
    }


    // first create the parking floor
    public ParkingLot createParkingLot(){
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i=0; i<totalFloor; i++){
               int floorNumber =i+1;
               parkingFloors.add(ParkingFloor.builder().floorNumber(floorNumber).parkingSpotsList(createParkingSpots(floorNumber)).displayBoards(DisplayBoards.builder().build()).build());
        }


        ParkingAttedants parkingAttendants = ParkingAttedants.builder().name("sss").email("ss@gmail.com").id(11).build() ;
        EntryGates gate = (EntryGates) EntryGates.builder().gateNumber(1)
                .displayBoards(EntryGateBoard.builder().numberOfAvailableFloor(10).numberOfSpotAvailablePerFloor(10).build())
                .parkingAttendants(parkingAttendants).build();
        ArrayList<EntryGates> entryGates1 = new ArrayList<>();
        entryGates1.add(gate);

        ExitGates exitGates = (ExitGates) ExitGates.builder().parkingAttendants(parkingAttendants).build();
        ArrayList<ExitGates> exitGate = new ArrayList<>();
        exitGate.add(exitGates);
        ParkingLot parkingLot = ParkingLot.builder().parkingFloorList(parkingFloors).name("sks")
                .address("banaglore")
                .entryGatesList(entryGates1)
                .exitGatesList(exitGate)
                .displayBoard(DisplayBoards.builder().build())
                .build();
        return parkingLot;
    }


}
