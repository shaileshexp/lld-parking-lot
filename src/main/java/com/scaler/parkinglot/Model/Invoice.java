package com.scaler.parkinglot.Model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@Setter
@Getter
public class Invoice extends BaseModel{
    private int invoiceId;
    private double amount;
    private Tickets ticket;
    private Date exitTime;
    private List<Payment> payment;
    private int exitGateId;
    private int OperatorId;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
}
