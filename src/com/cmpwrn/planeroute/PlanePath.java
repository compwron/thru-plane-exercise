package com.cmpwrn.planeroute;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlanePath {
    private String plane;
    private final List<LocationTime> locationTimes;

    public PlanePath(String line) {
//        PL2 175, 0010 B 0050,0110 A 0230, 0400 C 0440
        plane = new Plane(line).getName();
        locationTimes = extractTimes(line);
    }

    private List<LocationTime> extractTimes(String line) {
        return Arrays.asList(line.split(",")).stream()
                .filter((chunk) -> {
                    return chunk.trim().split(" ").length == 3;
                }).map((chunk) -> {
            return new LocationTime(chunk);
        }).collect(Collectors.toList());
    }
}
