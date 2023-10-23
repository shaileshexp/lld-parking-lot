package com.scaler.parkinglot.Model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Gates extends BaseModel{
    private int location;
    private ParkingAttedants parkingAttendants;


    protected Gates(BaseModelBuilder<?, ?> b) {
        super(b);
    }
}
