package com.ilisi.mstxfleetdbsmongodb.listener;

import com.ilisi.mstxfleetdbsmongodb.entity.Trip;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDTripListener extends AbstractMongoEventListener<Trip> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Trip> event) {
        Trip entity = event.getSource();
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}
