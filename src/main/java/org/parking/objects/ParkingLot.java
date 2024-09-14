package org.parking.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ParkingLot {
    private static ParkingLot parkingLotInstance;

    private String lotName;
    private String location;
    private final List<Floor> floors = new ArrayList<>();

    public static final Map<String, ParkingTicket> activeTickets = new HashMap<>();

    private ParkingLot(String lotName){
        this.lotName = lotName;
    }

    public static ParkingLot getInstance() {
        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot("Steve Jobs Parking Lot");
        }
        return parkingLotInstance;
    }

}
