package org.parking.objects;

import lombok.Getter;
import lombok.Setter;
import org.parking.Enums.PaymentType;
import org.parking.Enums.SpotType;
import org.parking.Enums.TicketStatus;

import java.sql.Timestamp;

@Getter
@Setter
public class ParkingTicket {
    private String vehicleNumber;

    private String spotId;
    private SpotType spotType;

    private Timestamp enteringTime;
    private Timestamp exitTime;

    private final String entryId; // TODO
    private String exitId; // TODO

    private PaymentType paymentType;
    private TicketStatus ticketStatus;

    private double fees;

    public ParkingTicket(String entryId, String vehicleNumber, SpotType spotType){
        this.entryId = entryId;
        this.vehicleNumber = vehicleNumber;
        this.spotType = spotType;
        this.ticketStatus = TicketStatus.ACTIVE;
    }

}
