package com.scaler.parkinglot.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Payment {
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private Tickets ticket;
    private double amount;

}
