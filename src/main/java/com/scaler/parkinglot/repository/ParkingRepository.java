package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingRepository {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    public void save(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
