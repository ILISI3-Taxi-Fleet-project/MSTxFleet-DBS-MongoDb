package com.ilisi.mstxfleetdbsmongodb.entity;

import com.ilisi.mstxfleetdbsmongodb.records.Location;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "trips")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Trip {
    @Id
    private UUID id;
    private String status;
    private Location destination;
    private Date created_at;
    @Nullable
    private User client;
    @Nullable
    private User driver;
}
