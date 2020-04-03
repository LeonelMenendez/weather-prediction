package com.vulcanos.weatherprediction.service;

import com.vulcanos.weatherprediction.model.DayWeatherConditionsModel;

public interface DayWeatherConditionsService {

    /**
     * @see SolarSystemService#getWeatherConditions(int)
     */
    DayWeatherConditionsModel findWeatherConditionsByDay(int day);

    /**
     * Saves or updates a <code>DayWeatherConditionsModel</code>.
     *
     * @param dayWeatherConditions the <code>DayWeatherConditionsModel</code> to
     *                             save or update.
     * @return the <code>DayWeatherConditionsModel</code> saved or updated.
     */
    DayWeatherConditionsModel saveOrUpdate(DayWeatherConditionsModel dayWeatherConditions);

    /**
     * Deletes all the entries in the repository.
     */
    void deleteAll();

    /**
     * Count all the entries in the repository
     *
     * @return the number of entries in the repository.
     */
    long count();

    /**
     * Populates the database with the number of days specified.
     *
     * @param daysToPopulate the number of days with which the database will be populated.
     * @see SolarSystemService#getWeatherConditions(int)
     */
    void populateDatabase(int daysToPopulate);
}
