package com.ilisi.mstxfleetdbsmongodb.repository;

import com.ilisi.mstxfleetdbsmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "users")
public interface UserRepository extends MongoRepository<User, UUID> {
    User findByUsername(String username);
}
