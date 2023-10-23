package com.scaler.parkinglot.repository;

import com.scaler.parkinglot.Model.EntryGates;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryGateRepository {
    List<EntryGates> entryGatesList = new ArrayList<>();
    public void save(List<EntryGates> entryGatesLs) {
        entryGatesLs.forEach(entryGates -> {
            entryGatesList.add(entryGates);
        });
    }

    public EntryGates getById(int entryGateId) {
        return entryGatesList.stream().filter(data-> data.getGateNumber()== entryGateId).findFirst().get();
    }
}
