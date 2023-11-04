package com.ilisi.mstxfleetdbsmongodb.controller;

import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "trips")
public interface TripController extends MongoRepository<Trip, UUID> {

}
