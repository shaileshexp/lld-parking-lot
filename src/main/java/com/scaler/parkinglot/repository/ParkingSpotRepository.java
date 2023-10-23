package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.ParkingSpots;
import com.scaler.parkinglot.Model.ParkingStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class ParkingSpotRepository {
    private List<ParkingSpots> parkingSpotsList = new ArrayList<>();

    public ParkingSpots save(ParkingSpots d) {
        parkingSpotsList.add(d);
        return d;
    }

    public ParkingSpots updateStatus(ParkingSpots parkingSpots) {
        ParkingSpots parkingSpots1 = parkingSpotsList.stream().filter(data -> data.getVehicleType() == parkingSpots.getVehicleType() && data.getFloorNumber()== parkingSpots.getFloorNumber() && data.getSportNumber() == parkingSpots.getSportNumber()).findFirst().get();
        parkingSpots1.setSpotStatus(ParkingStatus.OCCUPIED);
        return parkingSpots1;
    }
}
