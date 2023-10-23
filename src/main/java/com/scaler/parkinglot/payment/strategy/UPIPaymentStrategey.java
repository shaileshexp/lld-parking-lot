package com.scaler.parkinglot.payment.strategy;

import com.scaler.parkinglot.Model.Payment;
import com.scaler.parkinglot.Model.PaymentStatus;
import com.scaler.parkinglot.Model.PaymentType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UPIPaymentStrategey implements PaymentStrategey {
    @Override
    public Payment makePayment(double amount) {
        Payment p = Payment.builder().amount(amount).paymentType(PaymentType.UPI). paymentStatus(PaymentStatus.SUCCESS).build();
        return p;
    }
}
