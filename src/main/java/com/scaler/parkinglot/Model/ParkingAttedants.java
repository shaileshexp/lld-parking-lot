package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ParkingAttedants extends BaseModel{
    private String name;
    private String email;

    private String employeeId;
}
