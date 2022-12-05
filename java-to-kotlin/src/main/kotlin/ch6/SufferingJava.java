package ch6;

import java.util.List;
import java.util.stream.Collectors;

import static ch6.Collections.sorted;
import static ch6.Other.SOME_COMPLICATED_RESULT;
import static ch6.Other.routesFor;
import static ch6.Routes.getDepartsFrom;
import static java.util.Comparator.comparing;

public class SufferingJava {

    public static int sufferScoreFor(List<Journey> route) {
        return sufferScore(
                longestJourneysIn(route, 3),
                getDepartsFrom(route));
    }

    public static List<Journey> longestJourneysIn(
            List<Journey> journeys,
            int limit
    ) {
        var actualLimit = Math.min(journeys.size(), limit);
        return sorted(
                journeys,
                comparing(Journey::getDuration).reversed()
        ).subList(0, actualLimit);
//        journeys.sort(comparing(Journey::getDuration).reversed()); // <1>
//        var actualLimit = Math.min(journeys.size(), limit);
//        return journeys.subList(0, actualLimit);
    }

    public static List<List<Journey>> routesToShowFor(String itineraryId) {
        return bearable(routesFor(itineraryId));
    }

    private static List<List<Journey>> bearable(List<List<Journey>> routes) {
        return routes.stream()
                .filter(route -> sufferScoreFor(route) <= 10)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int sufferScore(
            List<Journey> longestJourneys,
            Location start
    ) {
        return SOME_COMPLICATED_RESULT();
    }
}
