package com.vulcanos.weatherprediction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class DayWeatherConditionsModel {

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty(value = "dia")
    private int day;

    @JsonProperty(value = "clima")
    private String weatherConditions;

    public DayWeatherConditionsModel(int day, String weatherConditions) {
        this.day = day;
        this.weatherConditions = weatherConditions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }
}