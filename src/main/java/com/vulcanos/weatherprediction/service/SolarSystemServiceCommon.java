package com.vulcanos.weatherprediction.service;

import com.vulcanos.weatherprediction.model.PeriodWeatherConditionsModel;
import com.vulcanos.weatherprediction.model.SolarSystemWeatherStatisticsModel;
import com.vulcanos.weatherprediction.type.WeatherConditions;

public abstract class SolarSystemServiceCommon {

    /**
     * Increase the statistic of the corresponding climatic conditions by one.
     *
     * @param solarSystemWeatherStatistics the solar system weather statistics to update.
     * @param weatherConditions            the weather conditions to compare.
     */
    public void updateSolarSystemWeatherStatistics(SolarSystemWeatherStatisticsModel solarSystemWeatherStatistics, WeatherConditions weatherConditions) {
        if (weatherConditions == WeatherConditions.DROUGHT) {
            solarSystemWeatherStatistics.setNumberOfDroughtPeriods(solarSystemWeatherStatistics.getNumberOfDroughtPeriods() + 1);
        } else if (weatherConditions == WeatherConditions.RAIN) {
            solarSystemWeatherStatistics.setNumberOfRainyPeriods(solarSystemWeatherStatistics.getNumberOfRainyPeriods() + 1);
        } else if (weatherConditions == WeatherConditions.OPTIMAL) {
            solarSystemWeatherStatistics.setNumberOfOptimalPeriods(solarSystemWeatherStatistics.getNumberOfOptimalPeriods() + 1);
        }
    }

    /**
     * Returns a new period with the given weather conditions and start day.
     *
     * @param weatherConditions the weather conditions of the new period.
     * @param startDay          the start day of the new period.
     * @return a new period with the given weather conditions and start day.
     */
    public PeriodWeatherConditionsModel getNewPeriodWeatherConditions(WeatherConditions weatherConditions, int startDay) {
        PeriodWeatherConditionsModel periodWeatherConditions = new PeriodWeatherConditionsModel();
        periodWeatherConditions.setWeatherConditions(weatherConditions);
        periodWeatherConditions.setStartDay(startDay);
        return periodWeatherConditions;
    }
}
