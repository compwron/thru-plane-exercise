package com.cmpwrn.planeroute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlaneInputParser {
    private List<PlanePath> planePaths;

    public PlaneInputParser(String fileName) {
        List<String> planeLines = planeLines(fileName);
        planePaths = pathsFrom(planeLines);
    }

    private List<PlanePath> pathsFrom(List<String> planeLines) {
        List<PlanePath> paths = planeLines.stream().map((line) -> {
            return new PlanePath(line);
        }).collect(Collectors.toList());
        return paths;
    }

    private List<String> planeLines(String fileName) {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .filter(line -> line.startsWith("PL"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<PlanePath> getPlanePaths() {
        return planePaths;
    }
}
