package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Vehicle findById(int vehicleId) {
        return vehicleList.stream().filter(data-> data.getId() == vehicleId).findFirst().get();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }
}
