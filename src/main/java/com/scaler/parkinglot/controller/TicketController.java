package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.Model.ParkingSpots;
import com.scaler.parkinglot.Model.Tickets;
import com.scaler.parkinglot.dto.CreateTicketRequest;
import com.scaler.parkinglot.repository.ParkingSpotRepository;
import com.scaler.parkinglot.services.ParkingSpotsService;
import com.scaler.parkinglot.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ap1/v1/ticket")
public class TicketController {

    private TicketService ticketService;
    private ParkingSpotsService parkingSpotsService;

    @PostMapping
    public Tickets generateTicket(@RequestBody  CreateTicketRequest createTicketRequest){
        return ticketService.createTicket(createTicketRequest);
    }

    @GetMapping
    public List<ParkingSpots> generateTicket(){
        return parkingSpotsService.getOccupiedSlot();
    }
}
