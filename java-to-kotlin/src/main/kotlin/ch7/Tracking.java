package ch7;

import java.time.Instant;
import java.util.Optional;

import static ch7.Trip.BookingStatus.BOOKED;
import static java.util.stream.Collectors.toList;

class Tracking implements ITrackTrips {

    private final Trips trips;

    public Tracking(Trips trips) {
        this.trips = trips;
    }

    @Override
    public Optional<Trip> currentTripFor(String customerId, Instant at) {
        var candidates = trips.currentTripsFor(customerId, at).stream()
                .filter((trip) -> trip.getBookingStatus() == BOOKED)
                .collect(toList());
        if (candidates.size() == 1)
            return Optional.of(candidates.get(0));
        else if (candidates.size() == 0)
            return Optional.empty();
        else
            throw new IllegalStateException(
                    "Unexpectedly more than one current trip for " + customerId
            );
    }
}
