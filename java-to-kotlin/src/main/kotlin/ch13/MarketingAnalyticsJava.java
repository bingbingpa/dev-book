package ch13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarketingAnalyticsJava {
    private final EventStore eventStore;

    public MarketingAnalyticsJava(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public double averageNumberOfEventsPerCompletedBooking(String timeRange) {
        Stream<Map<String, Object>> eventsForSuccessfulBookings =
                eventStore
                        .queryAsStream("type=CompletedBooking&timerange=" + timeRange)
                        .flatMap(event -> {
                            String interactionId = (String) event.get("interactionId");
                            return eventStore.queryAsStream("interactionId=" + interactionId);
                        });
        Map<String, List<Map<String, Object>>> bookingEventsByInteractionId =
                eventsForSuccessfulBookings.collect(Collectors.groupingBy(
                        event -> (String) event.get("interactionId"))
                );
        var averageNumberOfEventsPerCompletedBooking =
                bookingEventsByInteractionId
                        .values()
                        .stream()
                        .mapToInt(List::size)
                        .average();
        return averageNumberOfEventsPerCompletedBooking.orElse(Double.NaN);
    }
}
