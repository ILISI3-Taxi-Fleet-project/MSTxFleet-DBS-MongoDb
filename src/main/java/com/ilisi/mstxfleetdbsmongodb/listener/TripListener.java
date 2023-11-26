package com.ilisi.mstxfleetdbsmongodb.listener;

import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import com.ilisi.mstxfleetdbsmongodb.entity.User;
import com.ilisi.mstxfleetdbsmongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TripListener extends AbstractMongoEventListener<Trip> {

    private final UserRepository userRepository;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Trip> event) {
        Trip entity = event.getSource();
        System.out.println("TripListener.onBeforeConvert");
        if (entity.getId() == null) {
            // set the id
            entity.setId(UUID.randomUUID());
            // set the passenger (search by id)
            Optional<User> passeneger = Optional.ofNullable(
                    userRepository.findById(entity.getPassenger().getId())
                    .orElseThrow(() -> new RuntimeException("Cannot find passenger with id: " + entity.getPassenger().getId())));
            entity.setPassenger(passeneger.get());

        }else if(entity.getDriver() != null) {
            Optional<User> driver = Optional.ofNullable(
                    userRepository.findById(entity.getDriver().getId())
                            .orElseThrow(() -> new RuntimeException("Cannot find driver with id: " + entity.getDriver().getId())));
            entity.setDriver(driver.get());
        }
    }


}
