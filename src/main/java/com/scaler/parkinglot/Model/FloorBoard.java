package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class FloorBoard extends DisplayBoards{
    private int numberOfSpotAvailable;
}
