package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.ParkingAttedants;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ParkingAttedantsRepository {
    private ArrayList<ParkingAttedants> parkingAttedantsArrayList = new ArrayList<>() ;


    public ParkingAttedants findById(int parkingAttendantsId) {
        return parkingAttedantsArrayList.stream().filter(data-> data.getId() == parkingAttendantsId).findFirst().get();
    }
}
