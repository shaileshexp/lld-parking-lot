package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.Model.ParkingLot;
import com.scaler.parkinglot.dto.ParkingLotRequest;
import com.scaler.parkinglot.exception.InvalidParkigException;
import com.scaler.parkinglot.services.ParkingLotServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/parking-lot")
public class ParkingLotController {

    public ParkingLotServices parkingLotServices ;
    //create a parking lot

    @PostMapping
    public ResponseEntity<ParkingLot> createParkingLot(@RequestBody ParkingLotRequest parkingLotRequest){
        validation(parkingLotRequest);
        ParkingLot parkingLot = parkingLotRequest.createParkingLot();
        parkingLotServices.createParkingLot(parkingLot);
        return ResponseEntity.ok(parkingLot);
    }


    private void validation(ParkingLotRequest parkingLotRequest) {
        if(parkingLotRequest.getTotalFloor()<0 || parkingLotRequest.getTotalSlotPerFloor()<0){
            throw new InvalidParkigException("Parking floor or parking slot cant be 0 or less than 0");
        }
    }
}
