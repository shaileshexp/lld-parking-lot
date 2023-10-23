package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.ParkingFloor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ParkingFloorRepository {
    private List<ParkingFloor> parkingFloorList = new ArrayList<>();

    public void save(ParkingFloor floor){
        parkingFloorList.add(floor);
    }

    public ParkingFloor getById(int floorId) {
       return parkingFloorList.stream().filter(pf-> pf.getFloorNumber()== floorId).findFirst().get();
    }
}
