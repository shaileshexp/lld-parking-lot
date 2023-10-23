package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.ParkingFloor;
import com.scaler.parkinglot.Model.ParkingLot;
import com.scaler.parkinglot.Model.ParkingSpots;
import com.scaler.parkinglot.Model.VehicleType;
import com.scaler.parkinglot.repository.ParkingFloorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkingFloorService {

    public ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotsService parkingSpotsService;

    public void save(ParkingLot parkingLot) {

    }

    public void create(ParkingLot parkingLot) {
        parkingLot.getParkingFloorList().forEach(floor-> {
                     parkingFloorRepository.save(floor);
                     parkingSpotsService.create(floor.getParkingSpotsList());
                }
        );
    }

    public ParkingFloor getById(int floorId) {
       return  parkingFloorRepository.getById(floorId);
    }


}
