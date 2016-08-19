package com.cmpwrn.planeroute;

import java.util.List;

public class Main {
    public static void main(String... args) {
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            filename = "input1.txt";
        }
        List<PlanePath> planePaths = new PlaneInputParser(filename).getPlanePaths();
        Router router = new Router();
        List<String> planeLocations = router.reportPlaneLocations(planePaths);
        System.out.println(planeLocations);

        List<PeoplePath> peoplePaths = new PeopleInputParser(filename).getPeoplePaths();
        List<String> peoplePlaneAssignments = router.peoplePlaneAssignments(peoplePaths, planePaths);
        System.out.println(peoplePlaneAssignments);
    }
}
