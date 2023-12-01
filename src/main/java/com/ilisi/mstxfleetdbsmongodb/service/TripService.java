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
                        String created_at
                        ) {


        Trip trip = Trip.builder().
                id(UUID.fromString(tripId))
                .created_at(Instant.now())
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
                           String updated_at) {
        Trip trip = tripRepository.findById(UUID.fromString(tripId)).get();
        trip.setDriver(User.builder().id(UUID.fromString(driverId)).build());
        trip.setStatus(status);
        trip.setUpdated_at(Instant.now());
        tripRepository.save(trip);
    }

}
