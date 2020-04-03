package com.vulcanos.weatherprediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vulcanos.weatherprediction.type.WeatherConditions;

public class PeriodWeatherConditionsModel {

    @JsonProperty(value = "diaInicioPeriodo")
    private int startDay;

    @JsonProperty(value = "diaFinPeriodo")
    private int finalDay;

    @JsonProperty(value = "condicionesClimaticas")
    private WeatherConditions weatherConditions;

    @JsonProperty(value = "diaPicoMaximoLluvia")
    private int dayOfMaximumPeakOfRain;

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getFinalDay() {
        return finalDay;
    }

    public void setFinalDay(int finalDay) {
        this.finalDay = finalDay;
    }

    public int getDayOfMaximumPeakOfRain() {
        return dayOfMaximumPeakOfRain;
    }

    public void setDayOfMaximumPeakOfRain(int dayOfMaximumPeakOfRain) {
        this.dayOfMaximumPeakOfRain = dayOfMaximumPeakOfRain;
    }

    public WeatherConditions getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(WeatherConditions weatherConditions) {
        this.weatherConditions = weatherConditions;
    }
}
