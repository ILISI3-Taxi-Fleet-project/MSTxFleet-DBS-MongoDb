package com.ilisi.mstxfleetdbsmongodb.controller;

import com.ilisi.mstxfleetdbsmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "users")
public interface UserController extends MongoRepository<User, UUID> {
    User findByUsername(String username);
}
