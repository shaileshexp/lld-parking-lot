package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.ParkingAttedants;
import com.scaler.parkinglot.repository.ParkingAttedantsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingAttedantsServices {
    ParkingAttedantsRepository parkingAttedantsRepository;

    public ParkingAttedants getById(int parkingAttendantsId) {
        return parkingAttedantsRepository.findById(parkingAttendantsId);
    }
}
