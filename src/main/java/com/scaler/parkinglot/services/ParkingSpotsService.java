package com.scaler.parkinglot.services;

import com.scaler.parkinglot.Model.ParkingLot;
import com.scaler.parkinglot.Model.ParkingSpots;
import com.scaler.parkinglot.Model.ParkingStatus;
import com.scaler.parkinglot.Model.VehicleType;
import com.scaler.parkinglot.repository.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingSpotsService {
   private ParkingSpotRepository parkingSpotRepository;


    public void create(List<ParkingSpots> parkingSpotsListData) {
        parkingSpotsListData.stream().forEach(d-> parkingSpotRepository.save(d));
    }

    public List<ParkingSpots> allocateParking(VehicleType vehicleType) {
        Optional<ParkingSpots> first = parkingSpotRepository.getParkingSpotsList().stream().filter(spot -> spot.getVehicleType().equals(vehicleType) && spot.getSpotStatus() == ParkingStatus.FREE).findFirst();
        boolean isAvailable = first.isPresent();
        if(isAvailable){
            return List.of(first.get());
        }

        return getOccupiedSlotIfNotAvailableByType(vehicleType);

    }

    public ParkingSpots updateParkingSpot(ParkingSpots parkingSpots) {
        return parkingSpotRepository.updateStatus(parkingSpots);
    }

    public List<ParkingSpots> getOccupiedSlot() {
       return  parkingSpotRepository.getParkingSpotsList().stream().filter(data-> data.getSpotStatus()==ParkingStatus.OCCUPIED).collect(Collectors.toList());
    }

    public List<ParkingSpots>  getOccupiedSlotIfNotAvailableByType(VehicleType vehicleType) {
        //return  parkingSpotRepository.getParkingSpotsList().stream().filter(data-> data.getFloorNumber() == floorNumber && data.getSpotStatus()==ParkingStatus.FREE).collect(Collectors.toList()).size()!=0? true: false;
        List<ParkingSpots> data12 =  parkingSpotRepository.getParkingSpotsList().stream().filter(data-> data.getSpotStatus()==ParkingStatus.FREE).collect(Collectors.toList());
        Comparator<ParkingSpots> comparator = (a,b) -> {
            if(a.getFloorNumber() == b.getFloorNumber()) {
                return a.getSportNumber() - b.getSportNumber();
            }
            return a.getSportNumber() - b.getSportNumber();
        };

        data12.sort(comparator);

        int slotRequire = vehicleType.numberOfSlots(vehicleType);
        int consecutiveSlots = 0;
        int N = data12.size();
        int startIndex =0;
        ArrayList<ParkingSpots> ans = new ArrayList<>();
        for(int i=0; i<N-1; i++){
            if(data12.get(i).getFloorNumber() == data12.get(i+1).getFloorNumber() && data12.get(i).getSportNumber()+1==data12.get(i+1).getSportNumber()){
                startIndex=i;
                consecutiveSlots++;
                if(consecutiveSlots == slotRequire){
                    while(startIndex<=i){
                        ans.add(data12.get(startIndex));
                        startIndex++;
                    }
                    break;
                }
            }

            else{
                startIndex=i;
                consecutiveSlots=0;
            }
        }
        return ans;
    }
}
