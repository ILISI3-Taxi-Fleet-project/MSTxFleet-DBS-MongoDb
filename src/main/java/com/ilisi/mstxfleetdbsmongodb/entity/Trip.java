package com.ilisi.mstxfleetdbsmongodb.entity;

import com.ilisi.mstxfleetdbsmongodb.records.Location;
import com.mongodb.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Trip {
    @Id
    private UUID id;

    @NotNull(message = "Status is required")
    private String status;

    @NotNull(message = "Destination is required")
    @Valid
    private Location destination;

    @NotNull(message = "Start location is required")
    @Valid
    private Location startLocation;

    @PastOrPresent(message = "Created date must be in the past or present")
    private Instant createdAt;

    @PastOrPresent(message = "Updated date must be in the past or present")
    private Instant updatedAt;

    @NotNull(message = "Passenger is required")
    private User passenger;

    @Nullable
    private User driver;
}
