package org.parking.objects;

import lombok.Getter;
import lombok.Setter;
import org.parking.Enums.SpotType;

@Getter
@Setter
public class ParkingSpot {
    private final String spotId;
    private SpotType spotType;
    private boolean isAvailable;

    public ParkingSpot(String spotId, SpotType spotType){
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public ParkingSpot getSpot(String spotId){
        return this;
    }
}
