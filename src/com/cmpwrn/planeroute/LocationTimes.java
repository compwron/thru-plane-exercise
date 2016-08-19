package com.cmpwrn.planeroute;

import java.time.LocalTime;

public class LocationTimes {
    private final LocalTime arrivalTime;
    private final Location location;
    private final LocalTime departureTime;

    public LocationTimes(String chunk) {
        String[] pieces = chunk.split(" ");
        arrivalTime = LocalTime.parse(pieces[0]);
        location = Location.valueOf(pieces[1]);
        departureTime = LocalTime.parse(pieces[2]);

    }
}
