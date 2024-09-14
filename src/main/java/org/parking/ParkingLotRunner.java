package org.parking;

import org.parking.Enums.SpotType;
import org.parking.Users.Admin;
import org.parking.Users.FloorManager;
import org.parking.objects.Floor;
import org.parking.objects.ParkingLot;
import org.parking.objects.ParkingTicket;
import org.parking.services.ParkingLotManagementService;
import org.parking.services.ParkingTicketService;

public class ParkingLotRunner {
    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Admin admin = new Admin("Srikar", "contact");
        FloorManager revanth = new FloorManager("Revanth", "contact 2");
        FloorManager anudeep = new FloorManager("Anudeep", "contact 3");

        ParkingLotManagementService parkingLotManagementService = new ParkingLotManagementService();

        int floorNum = parkingLotManagementService.addNewFloor(admin, parkingLot);
        Floor floor1 = parkingLot.getFloors().get(floorNum);
        floor1.makeFloorManager(revanth);

        floorNum = parkingLotManagementService.addNewFloor(admin, parkingLot);
        Floor floor2 = parkingLot.getFloors().get(floorNum);
        floor2.makeFloorManager(anudeep);

        parkingLotManagementService.addParkingSpots(revanth, floor1, SpotType.TWO_WHEELER, 2);
        parkingLotManagementService.addParkingSpots(revanth, floor1, SpotType.FOUR_WHEELER, 5);
        parkingLotManagementService.addParkingSpots(revanth, floor1, SpotType.ELECTRIC_FOUR_WHEELER, 5);

        parkingLotManagementService.addParkingSpots(anudeep, floor2, SpotType.TWO_WHEELER, 5);
        parkingLotManagementService.addParkingSpots(anudeep, floor2, SpotType.FOUR_WHEELER, 5);
        parkingLotManagementService.addParkingSpots(anudeep, floor2, SpotType.ELECTRIC_FOUR_WHEELER, 5);

        ParkingTicketService parkingTicketService = new ParkingTicketService(parkingLot);
        ParkingTicket parkingTicket1 = parkingTicketService.generateParkingTicket("entry1", "5617", SpotType.TWO_WHEELER);
        ParkingTicket parkingTicket2 = parkingTicketService.generateParkingTicket("entry1", "5618", SpotType.TWO_WHEELER);
        ParkingTicket parkingTicket3 = parkingTicketService.generateParkingTicket("entry2", "5619", SpotType.TWO_WHEELER);

        parkingTicketService.exitParkingLot("5617", "exit1");
    }
}
