package com.cmpwrn.planeroute;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PlanePath {
    private String planeName;
    private final List<LocationTime> locationTimes;

    public PlanePath(String line) {
//        PL2, 0010 B 0050,0110 A 0230, 0400 C 0440
        planeName = planeName(line);
        locationTimes = extractTimes(line);
    }

    private String planeName(String line) {
        Pattern pattern = Pattern.compile("(PL\\d+),.*");
        Matcher matcher = pattern.matcher(line);
        matcher.matches();

        return matcher.group(1);
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
