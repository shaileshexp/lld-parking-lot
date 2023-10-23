package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.ParkingFloor;
import com.scaler.parkinglot.Model.ParkingLot;
import com.scaler.parkinglot.repository.ParkingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkingLotServices {

    private ParkingRepository parkingRepository;
    private ParkingFloorService parkingFloorService;
    private EntryGateServices entryGateServices;
    private ExitGateServices exitGateServices;


    public ParkingLot createParkingLot(ParkingLot parkingLot) {
         parkingRepository.save(parkingLot);
         parkingFloorService.create(parkingLot);
         entryGateServices.create(parkingLot.getEntryGatesList());
        exitGateServices.create(parkingLot.getExitGatesList());
        return null;
    }
}
