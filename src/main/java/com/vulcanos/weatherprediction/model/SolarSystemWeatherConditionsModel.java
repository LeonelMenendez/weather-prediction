package com.vulcanos.weatherprediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SolarSystemWeatherConditionsModel {

    @JsonProperty(value = "estadisticas")
    private SolarSystemWeatherStatisticsModel solarSystemWeatherStatistics;

    @JsonProperty(value = "periodosCondicionesClimaticas")
    private List<PeriodWeatherConditionsModel> periodWeatherConditionsList;

    public SolarSystemWeatherStatisticsModel getSolarSystemWeatherStatistics() {
        return solarSystemWeatherStatistics;
    }

    public void setSolarSystemWeatherStatistics(SolarSystemWeatherStatisticsModel solarSystemWeatherStatistics) {
        this.solarSystemWeatherStatistics = solarSystemWeatherStatistics;
    }

    public List<PeriodWeatherConditionsModel> getPeriodWeatherConditionsList() {
        return periodWeatherConditionsList;
    }

    public void setPeriodWeatherConditionsList(List<PeriodWeatherConditionsModel> periodWeatherConditionsList) {
        this.periodWeatherConditionsList = periodWeatherConditionsList;
    }
}
