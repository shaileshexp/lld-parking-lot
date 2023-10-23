package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.Tickets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
@Getter
public class PayCalculatorService {

    private TicketService ticketService;

    public double getAmount(Tickets ticket){
        Date entryTime = ticket.getEntryTime();
        Date currTime = new Date();
        long totalTime = currTime.getTime()-entryTime.getTime();
        if(totalTime>1 && totalTime<2){
            return 100.0;
        }
        else if(totalTime>2 && totalTime<3){
            return 200.0;
        }
        return 500.0;
    }
}
