package com.ilisi.mstxfleetdbsmongodb.listener;

import com.ilisi.mstxfleetdbsmongodb.entity.User;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUserListener extends AbstractMongoEventListener<User> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        User entity = event.getSource();
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}