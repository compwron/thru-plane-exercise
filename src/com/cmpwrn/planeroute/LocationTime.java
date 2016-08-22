package com.cmpwrn.planeroute;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocationTime {
    private final LocalTime arrivalTime;
    private final Location location;
    private final LocalTime departureTime;

    public LocationTime(String chunk) {
        String[] pieces = chunk.trim().split(" ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

        arrivalTime = LocalTime.parse(pieces[0], formatter);
        location = Location.valueOf(pieces[1]);
        departureTime = LocalTime.parse(pieces[2], formatter);
    }
}
