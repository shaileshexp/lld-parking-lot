package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.Model.Invoice;
import com.scaler.parkinglot.dto.CheckoutRequest;
import com.scaler.parkinglot.services.ExitGateServices;
import com.scaler.parkinglot.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentCounter {
    private ExitGateServices exitGateServices;

    @PostMapping
    public Invoice generateInvoice(@RequestBody CheckoutRequest checkoutRequest){
        return exitGateServices.checkOutprocess(checkoutRequest);
    }

}
