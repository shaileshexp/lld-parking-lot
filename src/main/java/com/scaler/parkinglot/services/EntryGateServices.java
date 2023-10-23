package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.EntryGates;
import com.scaler.parkinglot.repository.EntryGateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntryGateServices {
    private EntryGateRepository entryGateRepository;
    public void create(List<EntryGates> entryGatesList) {
        entryGateRepository.save(entryGatesList);
    }

    public EntryGates getById(int entryGateId) {
        return entryGateRepository.getById(entryGateId);
    }
}
