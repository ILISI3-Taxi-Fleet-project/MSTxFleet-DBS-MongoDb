package com.ilisi.mstxfleetdbsmongodb.repository;

import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "trips")
public interface TripRepository extends MongoRepository<Trip, UUID> {

    @Query("{ 'passenger.id' : ?0 }")
    List<Trip> findByPassengerIdOrderByCreatedAtDesc(@Param("passengerId") UUID passengerId, Sort sort);

    default Trip findLatestTripByPassengerId(UUID passengerId) {
        List<Trip> trips = findByPassengerIdOrderByCreatedAtDesc(passengerId, Sort.by(Sort.Direction.DESC, "created_at"));
        System.out.println("trips = " + trips);
        return trips.isEmpty() ? null : trips.get(0);
    }
}
