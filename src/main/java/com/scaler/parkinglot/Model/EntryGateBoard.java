package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
public class EntryGateBoard extends DisplayBoards{
    private int numberOfAvailableFloor;
    private int numberOfSpotAvailablePerFloor;
}
