package com.ilisi.mstxfleetdbsmongodb.service;


import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import com.ilisi.mstxfleetdbsmongodb.entity.User;
import com.ilisi.mstxfleetdbsmongodb.records.Location;
import com.ilisi.mstxfleetdbsmongodb.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public void addTrip(String passengerId, Double endLatitude, Double endLongitude) {
        Trip trip = Trip.builder().
                passenger(User.builder().id(UUID.fromString(passengerId)).build())
                .destination(new Location(endLatitude, endLongitude))
                .status("pending")
                .build();
        tripRepository.save(trip);
    }

    public void acceptTrip(String passengerId, String driverId) {
        Trip trip = tripRepository.findLatestTripByPassengerId(UUID.fromString(passengerId));
        trip.setDriver(User.builder().id(UUID.fromString(driverId)).build());
        trip.setStatus("accepted");
        tripRepository.save(trip);
    }

}
