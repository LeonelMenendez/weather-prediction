package com.vulcanos.weatherprediction.service;

import com.vulcanos.weatherprediction.model.PeriodWeatherConditionsModel;
import com.vulcanos.weatherprediction.model.SolarSystemWeatherConditionsModel;
import com.vulcanos.weatherprediction.model.SolarSystemWeatherStatisticsModel;
import com.vulcanos.weatherprediction.type.Planet;
import com.vulcanos.weatherprediction.type.WeatherConditions;
import com.vulcanos.weatherprediction.util.Geometry;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SolarSystemServiceImpl extends SolarSystemServiceCommon implements SolarSystemService {

    public boolean arePlanetsAligned(int day) {
        final Coordinate betasoidePosition = Planet.BETASOIDE.getPosition(day);
        final Coordinate ferengiPosition = Planet.FERENGI.getPosition(day);
        final Coordinate vulcanoPosition = Planet.VULCANO.getPosition(day);
        return Geometry.areCollinear(betasoidePosition, ferengiPosition, vulcanoPosition);
    }

    public boolean arePlanetsAlignedWithSun(int day) {
        final Coordinate sunPosition = this.SUN_POSITION;
        final Coordinate betasoidePosition = Planet.BETASOIDE.getPosition(day);
        final Coordinate ferengiPosition = Planet.FERENGI.getPosition(day);
        return arePlanetsAligned(day) && Geometry.areCollinear(sunPosition, betasoidePosition, ferengiPosition);
    }

    public boolean isSunInsideTriangle(int day) {
        final Coordinate sunPosition = this.SUN_POSITION;
        final Coordinate betasoidePosition = Planet.BETASOIDE.getPosition(day);
        final Coordinate ferengiPosition = Planet.FERENGI.getPosition(day);
        final Coordinate vulcanoPosition = Planet.VULCANO.getPosition(day);
        return Geometry.isPointInsideTriangle(betasoidePosition, ferengiPosition, vulcanoPosition, sunPosition);
    }

    public double getTrianglePerimeter(int day) {
        final Coordinate betasoidePosition = Planet.BETASOIDE.getPosition(day);
        final Coordinate ferengiPosition = Planet.FERENGI.getPosition(day);
        final Coordinate vulcanoPosition = Planet.VULCANO.getPosition(day);
        return Geometry.getTrianglePerimeter(betasoidePosition, ferengiPosition, vulcanoPosition);
    }

    public WeatherConditions getWeatherConditions(int day) {
        if (arePlanetsAligned(day)) {
            if (arePlanetsAlignedWithSun(day)) {
                return WeatherConditions.DROUGHT;
            } else {
                return WeatherConditions.OPTIMAL;
            }
        } else {
            if (isSunInsideTriangle(day)) {
                return WeatherConditions.RAIN;
            }
        }

        return WeatherConditions.UNDETERMINED;
    }

    public SolarSystemWeatherConditionsModel getSolarSystemWeatherConditionsInformation(int startDay, int finalDay) {
        List<PeriodWeatherConditionsModel> periodWeatherConditionsList = new LinkedList<>();
        SolarSystemWeatherStatisticsModel solarSystemWeatherStatistics = new SolarSystemWeatherStatisticsModel();
        double maxTrianglePerimeter = 0;
        int dayOfMaximumPeakOfRain = -1;

        WeatherConditions currentWeatherConditions = getWeatherConditions(startDay);
        WeatherConditions lastWeatherConditions = currentWeatherConditions;
        PeriodWeatherConditionsModel periodWeatherConditions = getNewPeriodWeatherConditions(currentWeatherConditions, startDay);
        updateSolarSystemWeatherStatistics(solarSystemWeatherStatistics, currentWeatherConditions);

        for (int day = startDay + 1; day <= finalDay; day++) {
            currentWeatherConditions = getWeatherConditions(day);

            if (currentWeatherConditions == lastWeatherConditions) {
                double trianglePerimeter = getTrianglePerimeter(day);
                if (periodWeatherConditions.getWeatherConditions() == WeatherConditions.RAIN && trianglePerimeter >= maxTrianglePerimeter) {
                    maxTrianglePerimeter = trianglePerimeter;
                    dayOfMaximumPeakOfRain = day;
                }
            } else {
                periodWeatherConditions.setDayOfMaximumPeakOfRain(dayOfMaximumPeakOfRain);
                periodWeatherConditions.setFinalDay(day - 1);
                periodWeatherConditionsList.add(periodWeatherConditions);

                maxTrianglePerimeter = 0;
                dayOfMaximumPeakOfRain = -1;
                updateSolarSystemWeatherStatistics(solarSystemWeatherStatistics, currentWeatherConditions);
                periodWeatherConditions = getNewPeriodWeatherConditions(currentWeatherConditions, day);
            }

            lastWeatherConditions = currentWeatherConditions;
        }

        if (lastWeatherConditions != getWeatherConditions(finalDay + 1)) {
            periodWeatherConditions.setFinalDay(finalDay);
        } else {
            periodWeatherConditions.setFinalDay(-1);
        }
        periodWeatherConditions.setDayOfMaximumPeakOfRain(dayOfMaximumPeakOfRain);
        periodWeatherConditionsList.add(periodWeatherConditions);

        SolarSystemWeatherConditionsModel solarSystemWeatherConditions = new SolarSystemWeatherConditionsModel();
        solarSystemWeatherConditions.setPeriodWeatherConditionsList(periodWeatherConditionsList);
        solarSystemWeatherConditions.setSolarSystemWeatherStatistics(solarSystemWeatherStatistics);
        return solarSystemWeatherConditions;
    }
}
