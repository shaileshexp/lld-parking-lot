package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.Invoice;
import com.scaler.parkinglot.Model.Payment;
import com.scaler.parkinglot.Model.Tickets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Getter
@Service
public class InvoiceService {

    public Invoice generateInvoice(Payment payment){
        Invoice in =Invoice.builder().
                invoiceId(123).
                amount(payment.getAmount())
                .paymentType(payment.getPaymentType()).
                ticket(payment.getTicket()).
                payment(List.of(payment)).
                build();
        return in;
    }
}
