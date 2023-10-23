package com.scaler.parkinglot.dto;

import com.scaler.parkinglot.Model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class CheckoutRequest {
    private int ticketId;

    private String paymentType;
    private int exitGateId;
    private int parkingAttendantId;
}
