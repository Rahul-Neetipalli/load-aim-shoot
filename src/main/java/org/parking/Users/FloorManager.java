package org.parking.Users;

import org.parking.objects.ParkingSpot;

public class FloorManager extends User{
    public FloorManager(String name, String contact){
        super(name, contact);
    }

    private void alterAvailability(ParkingSpot spot, boolean availability){
        spot.setAvailable(availability);
    }
}
