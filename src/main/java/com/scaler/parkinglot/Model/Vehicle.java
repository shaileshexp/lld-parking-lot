package com.scaler.parkinglot.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
public class Vehicle extends BaseModel{
    private String owner;
    private int vehicleNumber;

    private int drivingLicense;

    private int slotRequire;
    public Vehicle(){
        super();
    }
}
