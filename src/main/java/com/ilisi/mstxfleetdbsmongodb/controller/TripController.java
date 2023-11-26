package com.ilisi.mstxfleetdbsmongodb.controller;

import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import com.ilisi.mstxfleetdbsmongodb.entity.User;
import com.ilisi.mstxfleetdbsmongodb.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TripController {

    private final TripRepository tripRepository;

    @PostMapping("/trips/acceptTrip/{passengerId}")
    public Trip patchTrip(@PathVariable UUID passengerId, @RequestBody User driver) {
        // Find the latest trip for the given passenger
        Trip latestTrip = tripRepository.findLatestTripByPassengerId(passengerId);
        System.out.println("latestTrip = " + latestTrip);
        System.out.println("driver = " + driver);
        // Update the driver
        latestTrip.setDriver(driver);
        // Save the updated trip
        return tripRepository.save(latestTrip);
    }
}