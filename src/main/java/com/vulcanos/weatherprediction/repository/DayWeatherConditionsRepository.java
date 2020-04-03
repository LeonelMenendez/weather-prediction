package com.vulcanos.weatherprediction.repository;

import com.vulcanos.weatherprediction.model.DayWeatherConditionsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayWeatherConditionsRepository extends MongoRepository<DayWeatherConditionsModel, String> {
    DayWeatherConditionsModel findByDay(int day);
}