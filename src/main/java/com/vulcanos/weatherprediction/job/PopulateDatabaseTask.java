package com.vulcanos.weatherprediction.job;

import com.vulcanos.weatherprediction.service.DayWeatherConditionsService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Populates the database with the weather conditions of each day since day zero
 * to the specified one in the properties file.
 */
@Configuration
public class PopulateDatabaseTask implements Tasklet {

    private final int daysToPopulate;
    private final DayWeatherConditionsService dayWeatherConditionsService;

    public PopulateDatabaseTask(@Value("${galaxy.number-of-days-to-populate}") int daysToPopulate, DayWeatherConditionsService dayWeatherConditionsService) {
        this.daysToPopulate = daysToPopulate;
        this.dayWeatherConditionsService = dayWeatherConditionsService;
    }

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        dayWeatherConditionsService.deleteAll();
        dayWeatherConditionsService.populateDatabase(daysToPopulate);
        return RepeatStatus.FINISHED;
    }
}
