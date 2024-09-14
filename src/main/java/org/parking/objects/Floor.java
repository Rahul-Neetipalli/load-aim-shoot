package org.parking.objects;

import lombok.Getter;
import org.parking.Users.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Getter
public class Floor {
    private final int floorNum;
    private final HashSet<String> floorManagers;
    private final List<ParkingSpot> spots;

    public Floor(int floorNum){
        this.floorNum = floorNum;
        this.floorManagers = new HashSet<>();
        this.spots = new ArrayList<>();
    }

    public void makeFloorManager(User user){
        this.floorManagers.add(user.getUserId());
    }

    public void addParkingSpot(ParkingSpot spot){
        this.spots.add(spot);
    }


}
