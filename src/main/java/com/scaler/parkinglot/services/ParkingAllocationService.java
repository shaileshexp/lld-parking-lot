package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.ParkingSpots;
import com.scaler.parkinglot.Model.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ParkingAllocationService {
    private ParkingSpotsService parkingSpotsService;

    public List<ParkingSpots> allocateParking(VehicleType vehicleType) {
        return parkingSpotsService.allocateParking(vehicleType);
    }

    public ParkingSpots updateParkingSpot(ParkingSpots parkingSpots){
        return parkingSpotsService.updateParkingSpot(parkingSpots);
    }
}
