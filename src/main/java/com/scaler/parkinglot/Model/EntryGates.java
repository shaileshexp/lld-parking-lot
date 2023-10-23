package com.scaler.parkinglot.Model;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class EntryGates extends Gates{
    private int gateNumber;

    private DisplayBoards displayBoards;

}
