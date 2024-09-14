package org.parking.services;

import org.parking.Enums.SpotType;
import org.parking.Users.Admin;
import org.parking.Users.FloorManager;
import org.parking.Users.User;
import org.parking.objects.Floor;
import org.parking.objects.ParkingLot;
import org.parking.objects.ParkingSpot;

import java.util.List;
import java.util.UUID;

public class ParkingLotManagementService {

    public void makeFloorManager(User admin, User floorManager, Floor floor){
        if(admin instanceof Admin && floorManager instanceof FloorManager){
            floor.makeFloorManager(floorManager);
        }
    }

    public int addNewFloor(User user, ParkingLot parkingLot){
        if(user instanceof Admin){
            List<Floor> floors = parkingLot.getFloors();
            floors.add(new Floor(floors.size()));
            return floors.size() - 1;
        }
        else{
            // throw No Access
        }
        return 0;
    }

    public void addParkingSpots(User user, Floor floor, SpotType spotType, int numberOfSpots){
        if(user instanceof FloorManager && floor.getFloorManagers().contains(user.getUserId())){
            for(int i = 0; i<numberOfSpots; i++){
                floor.addParkingSpot(new ParkingSpot(UUID.randomUUID().toString(), spotType));
            }
        }
    }

    public void alterSpotType(User user, ParkingSpot spot, SpotType spotType){
        if(user instanceof FloorManager){
            spot.setSpotType(spotType);
        }
    }
}
