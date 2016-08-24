package com.cmpwrn.planeroute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plane {
    private final int capacity;
    private String name;

    public Plane(String line) {
        this.capacity = capacity(line);
        this.name = planeName(line);
    }

    private int capacity(String line) {
        Pattern pattern = Pattern.compile("PL\\d+ (\\d+),.*");
        Matcher matcher = pattern.matcher(line);
        matcher.matches();

        return Integer.getInteger(matcher.group(1));
    }


    private String planeName(String line) {
        Pattern pattern = Pattern.compile("(PL\\d+) .*");
        Matcher matcher = pattern.matcher(line);
        matcher.matches();

        return matcher.group(1);
    }

    public String getName() {
        return name;
    }
}
