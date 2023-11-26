package com.ilisi.mstxfleetdbsmongodb.entity;

import com.ilisi.mstxfleetdbsmongodb.records.Location;
import com.mongodb.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Trip {
    @Id
    private UUID id;

    @NotNull(message = "Status is required")
    private String status;

    @NotNull(message = "Destination is required")
    @Valid
    private Location destination;

    @PastOrPresent(message = "Created date must be in the past or present")
    private Date created_at = new Date();

    @NotNull(message = "Passenger is required")
    private User passenger;

    @Nullable
    private User driver;
}
