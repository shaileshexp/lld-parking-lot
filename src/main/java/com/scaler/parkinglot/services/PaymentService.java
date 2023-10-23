package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.*;
import com.scaler.parkinglot.payment.strategy.PaymentStrategey;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;


@Getter
@Service
public class PaymentService {

    @Setter
    private  PaymentStrategey paymentStrategey ;

    private InvoiceService invoiceService;

    public PaymentService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public Invoice makePayment(double amount){
        Payment payment = paymentStrategey.makePayment(amount);
        if(payment.getPaymentStatus() ==PaymentStatus.SUCCESS){
            return invoiceService.generateInvoice(payment);
        }
        return Invoice.builder().build();
    }
}
