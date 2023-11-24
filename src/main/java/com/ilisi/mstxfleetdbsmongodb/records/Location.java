package com.ilisi.mstxfleetdbsmongodb.records;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public record Location(
        @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be greater than or equal to -90")
        @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be less than or equal to 90")
        double latitude,

        @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be greater than or equal to -180")
        @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be less than or equal to 180")
        double longitude
) { }