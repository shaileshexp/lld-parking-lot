package com.scaler.parkinglot.Model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PaymentType {
    ONLINE("online"),
    CASH("cash"),
    UPI("upi");

    private String mode;
    PaymentType(String mode) {
        this.mode =  mode;
    }

    public String getMode(){
        return this.mode;
    }
}
