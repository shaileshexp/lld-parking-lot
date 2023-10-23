package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.*;
import com.scaler.parkinglot.dto.CreateTicketRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
@AllArgsConstructor
@Getter
public class TicketService {

    TicketRepository ticketRepository;
    ParkingAllocationService parkingAllocationService;
    ParkingFloorService parkingFloorService;
    EntryGateServices entryGateServices;
    ParkingAttedantsServices parkingAttedantsServices;
    VehicleServices vehicleServices;

    public  Tickets createTicket(CreateTicketRequest ticketRequest){
        VehicleType vehicleType = ticketRequest.getVehicleType();
        List<ParkingSpots> parkingSpots = parkingAllocationService.allocateParking(vehicleType);
       // EntryGates gated = entryGateServices.getById(ticketRequest.getEntryGateNumber());
       // ParkingAttedants entryParkAttendants = parkingAttedantsServices.getById(ticketRequest.getParkingAttendant());
        parkingSpots.stream().forEach(d-> {
            d.setSpotStatus(ParkingStatus.OCCUPIED);
            parkingAllocationService.updateParkingSpot(d);
        });

        int ticketId = Math.abs(new Random().nextInt());
        Tickets tick = null;
        if(parkingSpots.size()==1){
             tick = Tickets.builder().id(ticketId).
                    createdAt(new Date()).
                    updatedAt(new Date()).
                    entryTime(new Date()).
                    parkingAttendants(ticketRequest.getParkingAttendant()).
                    vehicleNumber(ticketRequest.getVehicle().getVehicleNumber()).
                    gateId(ticketRequest.getEntryGateNumber()).
                    floorNumber(parkingSpots.get(0).getFloorNumber()).
                    spotNumber(parkingSpots.get(0).getSportNumber()).
                    build();

        }else{
             tick = Tickets.builder().id(ticketId).
                    createdAt(new Date()).
                    updatedAt(new Date()).
                    entryTime(new Date()).
                    parkingAttendants(ticketRequest.getParkingAttendant()).
                    vehicleNumber(ticketRequest.getVehicle().getVehicleNumber()).
                    gateId(ticketRequest.getEntryGateNumber()).
                    parkingSpotsList(parkingSpots).

                    build();
        }
        // save to DB
        ticketRepository.savetickets(tick);
        return tick;
    }

    Tickets getById(int ticketId){
        return ticketRepository.getById(ticketId);
    }

}
