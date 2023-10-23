package com.scaler.parkinglot.payment.strategy;

import com.scaler.parkinglot.Model.Payment;



public interface PaymentStrategey {
        Payment makePayment(double amount);
}
