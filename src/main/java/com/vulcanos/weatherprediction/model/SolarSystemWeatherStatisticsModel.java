package com.vulcanos.weatherprediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolarSystemWeatherStatisticsModel {

    @JsonProperty(value = "cantidadPeriodosSequia")
    private int numberOfDroughtPeriods;

    @JsonProperty(value = "cantidadPeriodosLluviosos")
    private int numberOfRainyPeriods;

    @JsonProperty(value = "cantidadPeriodosOptimos")
    private int numberOfOptimalPeriods;

    public int getNumberOfDroughtPeriods() {
        return numberOfDroughtPeriods;
    }

    public void setNumberOfDroughtPeriods(int numberOfDroughtPeriods) {
        this.numberOfDroughtPeriods = numberOfDroughtPeriods;
    }

    public int getNumberOfRainyPeriods() {
        return numberOfRainyPeriods;
    }

    public void setNumberOfRainyPeriods(int numberOfRainyPeriods) {
        this.numberOfRainyPeriods = numberOfRainyPeriods;
    }

    public int getNumberOfOptimalPeriods() {
        return numberOfOptimalPeriods;
    }

    public void setNumberOfOptimalPeriods(int numberOfOptimalPeriods) {
        this.numberOfOptimalPeriods = numberOfOptimalPeriods;
    }
}
