package com.vulcanos.weatherprediction.service;

import com.vulcanos.weatherprediction.model.DayWeatherConditionsModel;
import com.vulcanos.weatherprediction.repository.DayWeatherConditionsRepository;
import com.vulcanos.weatherprediction.type.WeatherConditions;
import org.springframework.stereotype.Service;

@Service
public class DayWeatherConditionsServiceImpl implements DayWeatherConditionsService {

    private final DayWeatherConditionsRepository dayWeatherConditionsRepository;
    private final SolarSystemService solarSystemService;

    public DayWeatherConditionsServiceImpl(DayWeatherConditionsRepository dayWeatherConditionsRepository, SolarSystemService solarSystemService) {
        this.dayWeatherConditionsRepository = dayWeatherConditionsRepository;
        this.solarSystemService = solarSystemService;
    }

    public DayWeatherConditionsModel findWeatherConditionsByDay(int day) {
        return dayWeatherConditionsRepository.findByDay(day);
    }

    public DayWeatherConditionsModel saveOrUpdate(DayWeatherConditionsModel dayWeatherConditions) {
        return dayWeatherConditionsRepository.save(dayWeatherConditions);
    }

    public void deleteAll() {
        dayWeatherConditionsRepository.deleteAll();
    }

    public long count() {
        return dayWeatherConditionsRepository.count();
    }

    public void populateDatabase(int daysToPopulate) {
        for (int day = 0; day < daysToPopulate; day++) {
            WeatherConditions weatherConditions = solarSystemService.getWeatherConditions(day);
            DayWeatherConditionsModel dayWeatherConditions = new DayWeatherConditionsModel(day, weatherConditions.getDescription());
            this.saveOrUpdate(dayWeatherConditions);
        }
    }
}
