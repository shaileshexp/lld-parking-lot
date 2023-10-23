package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.Vehicle;
import com.scaler.parkinglot.dto.VehicleCreateRequest;
import com.scaler.parkinglot.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleServices {
    VehicleRepository vehicleRepository;
    public Vehicle getById(int vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    public Vehicle createVehicleEntry(VehicleCreateRequest vehicleCreateRequest) {

        return vehicleRepository.save(vehicleCreateRequest.getVehicle());
    }
}
