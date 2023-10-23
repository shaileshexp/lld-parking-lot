package com.scaler.parkinglot.payment.strategy;

import com.scaler.parkinglot.Model.Payment;
import com.scaler.parkinglot.Model.PaymentStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CashPaymentStrategey implements PaymentStrategey {

    @Override
    public Payment makePayment(double amount) {
        Payment p = Payment.builder().paymentStatus(PaymentStatus.SUCCESS).build();
        return p;
    }
}
