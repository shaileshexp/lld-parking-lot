package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.Model.BaseModel;
import com.scaler.parkinglot.Model.Vehicle;
import com.scaler.parkinglot.dto.VehicleCreateRequest;
import com.scaler.parkinglot.services.VehicleServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController extends BaseModel {
    private VehicleServices vehicleServices;

    public Vehicle vehicleEntry(@RequestBody VehicleCreateRequest vehicleCreateRequest){
            return vehicleServices.createVehicleEntry(vehicleCreateRequest);
    }
}
