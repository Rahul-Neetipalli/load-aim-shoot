package org.parking.services;

import org.parking.Enums.SpotType;
import org.parking.Enums.TicketStatus;
import org.parking.objects.Floor;
import org.parking.objects.ParkingLot;
import org.parking.objects.ParkingSpot;
import org.parking.objects.ParkingTicket;

import java.sql.Timestamp;
import java.time.Instant;

import static org.parking.objects.ParkingLot.activeTickets;

public class ParkingTicketService {

    private ParkingLot parkingLot;

    public ParkingTicketService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket generateParkingTicket(String entryId, String vehicleNumber, SpotType spotType){
        ParkingTicket parkingTicket = new ParkingTicket(entryId, vehicleNumber, spotType);
        parkingTicket.setEnteringTime(Timestamp.from(Instant.now()));
        ParkingSpot nearestSpot = findNearestSpot(entryId, spotType);
        parkingTicket.setSpotId(nearestSpot.getSpotId());
        activeTickets.put(vehicleNumber, parkingTicket);
        return parkingTicket;
    }

    private ParkingSpot findNearestSpot(String entryId, SpotType spotType){
        //TODO: Incorporate using entryId to find the neearest spot
        for(Floor floor: parkingLot.getFloors()){
            for(ParkingSpot spot : floor.getSpots()){
                if(spot.isAvailable() && spotType.equals(spot.getSpotType())) {
                    spot.setAvailable(false);
                    return spot;
                }
            }
        }

        return null; // None available TODO: Know this beforehand?
    }

    public ParkingTicket exitParkingLot(String vehicleNumber, String exitId){
        if(!activeTickets.containsKey(vehicleNumber)){
            // Throw Error
        }
        ParkingTicket parkingTicket = activeTickets.get(vehicleNumber);
        parkingTicket.setExitTime(Timestamp.from(Instant.now()));
        parkingTicket.setFees(getParkingFees(parkingTicket));
        parkingTicket.setExitId(exitId);
        // Collect Fees - TODO


        // Update Parking Ticket
        parkingTicket.setTicketStatus(TicketStatus.CLOSED);

        // Persist in DB

        // Remove from Active Tickets
        activeTickets.remove(vehicleNumber);
        return parkingTicket;
    }

    // TODO - Is this a good idea?
    public double getParkingFees(ParkingTicket parkingTicket){
        // TODO - Logic based on spotType, enteringTime & exitTime
        return 0.0;
    }
}
