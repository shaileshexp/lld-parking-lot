package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.ExitGates;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class ExitGateRepository {
    List<ExitGates> exitGatesList = new ArrayList<>();

    public void save(ExitGates gates){
        exitGatesList.add(gates);
    }
    public void add(ExitGates exitGates) {
        exitGatesList.add(exitGates);
    }
}
