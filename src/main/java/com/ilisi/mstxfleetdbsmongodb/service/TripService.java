package com.ilisi.mstxfleetdbsmongodb.service;


import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import com.ilisi.mstxfleetdbsmongodb.entity.User;
import com.ilisi.mstxfleetdbsmongodb.records.Location;
import com.ilisi.mstxfleetdbsmongodb.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public void addTrip(String tripId,
                        String passengerId,
                        Double endLatitude,
                        Double endLongitude,
                        Double startLatitude,
                        Double startLongitude,
                        String status,
                        Instant createdAt
                        ) {


        Trip trip = Trip.builder().
                id(UUID.fromString(tripId))
                .createdAt(createdAt)
                .passenger(User.builder().id(UUID.fromString(passengerId)).build())
                .destination(new Location(endLatitude, endLongitude))
                .startLocation(new Location(startLatitude, startLongitude))
                .status(status)
                .build();

        tripRepository.save(trip);
    }

    public void acceptTrip(String tripId,
                           String driverId,
                           String status,
                           Instant updatedAt) {
        Trip trip = tripRepository.findById(UUID.fromString(tripId)).orElseThrow(
                () -> new RuntimeException("Trip not found")
        );

        trip.setDriver(User.builder().id(UUID.fromString(driverId)).build());
        trip.setStatus(status);
        trip.setUpdatedAt(updatedAt);
        tripRepository.save(trip);
    }

}
