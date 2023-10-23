package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.Tickets;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketRepository {
    private List<Tickets> ticketsList = new ArrayList<>();

    public void savetickets(Tickets tickets){
        ticketsList.add(tickets);
    }
    public Tickets getById(int ticketId) {
        return ticketsList.stream().filter(tickets -> tickets.id== ticketId).collect(Collectors.toList()).get(0);
    }
}
