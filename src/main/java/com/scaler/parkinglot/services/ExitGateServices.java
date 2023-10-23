package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.ExitGates;
import com.scaler.parkinglot.Model.Invoice;
import com.scaler.parkinglot.Model.PaymentType;
import com.scaler.parkinglot.Model.Tickets;
import com.scaler.parkinglot.dto.CheckoutRequest;
import com.scaler.parkinglot.payment.strategy.CashPaymentStrategey;
import com.scaler.parkinglot.payment.strategy.UPIPaymentStrategey;
import com.scaler.parkinglot.repository.ExitGateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExitGateServices {
    private ExitGateRepository exitGateRepository;
    private TicketService ticketService;
    private PaymentService paymentService;
    private  PayCalculatorService payCalculatorService;

    public Invoice checkOutprocess(CheckoutRequest checkoutRequest) {
        Tickets ticket = ticketService.getById(checkoutRequest.getTicketId());
        double amount = payCalculatorService.getAmount(ticket);
        setPaymentStrategy(checkoutRequest);
        return paymentService.makePayment(amount);
    }

    private void setPaymentStrategy(CheckoutRequest checkoutRequest) {
        if(checkoutRequest.getPaymentType().equals("upi")){
            paymentService.setPaymentStrategey(new UPIPaymentStrategey());
        }else if(checkoutRequest.getPaymentType().equals("cash")){
            paymentService.setPaymentStrategey(new CashPaymentStrategey());
        }
    }

    public void save(List<ExitGates> exitGatesList) {
        exitGatesList.stream().forEach(data-> exitGateRepository.save(data));

    }

    public void create(List<ExitGates> exitGatesList) {
        exitGatesList.forEach(exitGates -> {
            exitGateRepository.add(exitGates);
        });
    }
}
