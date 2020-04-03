package com.vulcanos.weatherprediction.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Contains the possible weather conditions.
 */
public enum WeatherConditions {

    DROUGHT("sequía"),
    RAIN("lluvia"),
    UNDETERMINED("indeterminable"),
    OPTIMAL("óptimas");

    @JsonValue()
    private final String description;

    WeatherConditions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
