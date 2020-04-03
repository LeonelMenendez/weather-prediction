package com.vulcanos.weatherprediction.service;

import com.vulcanos.weatherprediction.model.PeriodWeatherConditionsModel;
import com.vulcanos.weatherprediction.model.SolarSystemWeatherConditionsModel;
import com.vulcanos.weatherprediction.type.WeatherConditions;
import org.locationtech.jts.geom.Coordinate;

public interface SolarSystemService {

    Coordinate SUN_POSITION = new Coordinate(0, 0);

    /**
     * Determines if the planets in the solar system are aligned.
     *
     * @param day the number of days that have passed since day zero.
     * @return <code>true</code> if the planets in the solar system are aligned, <code>false</code> otherwise.
     */
    boolean arePlanetsAligned(int day);

    /**
     * Determines if the planets in the solar system are aligned with the the sun.
     *
     * @param day the number of days that have passed since day zero.
     * @return <code>true</code> if the planets in the solar system are aligned with the sun, <code>false</code> otherwise.
     */
    boolean arePlanetsAlignedWithSun(int day);

    /**
     * Determines if the sun is inside the triangle formed by the planets.
     *
     * @param day the number of days that have passed since day zero.
     * @return <code>true</code> if the sun is inside the triangle formed by the planets, <code>false</code> otherwise.
     */
    boolean isSunInsideTriangle(int day);

    /**
     * Returns the perimeter of the triangle formed by the planets.
     *
     * @param day the number of days that have passed since day zero.
     * @return the perimeter of the triangle formed by the planets.
     */
    double getTrianglePerimeter(int day);

    /**
     * Returns the weather conditions of the solar system on the specified day.
     *
     * <p>{@link WeatherConditions#DROUGHT} if the planets are aligned between them and
     * with the sun.</p>
     * <p>{@link WeatherConditions#OPTIMAL} if the planets are aligned between them
     * but not with the sun.</p>
     * <p>{@link WeatherConditions#RAIN} if the planets are not aligned and the sun
     * is inside the triangle formed by the planets.</p>
     * <p>{@link WeatherConditions#UNDETERMINED} if none of the above conditions are met.</p>
     *
     * @param day the number of days that have passed since day zero.
     * @return the weather conditions of the solar system on the specified day.
     */
    WeatherConditions getWeatherConditions(int day);

    /**
     * Returns a list of periods composed by a set of days with the same weather conditions, and
     * statistics of the number of periods of each climatic condition of the period formed by
     * the specified <code>startDay</code> and <code>finalDay</code>.
     *
     * <p>{@link PeriodWeatherConditionsModel#getDayOfMaximumPeakOfRain()}<link> will be -1 if it is
     * not a rainy period.</p>
     * <p>{@link PeriodWeatherConditionsModel#getFinalDay()} ()}<link> will be -1 if the end of the
     * period cannot be determined with the given final day.</p>
     *
     * @param startDay the day the period begins.
     * @param finalDay the day the period ends.
     * @return a list of periods composed by a set of days with the same weather conditions and
     * statistics of the number of periods of each climatic condition.
     */
    SolarSystemWeatherConditionsModel getSolarSystemWeatherConditionsInformation(int startDay, int finalDay);
}
