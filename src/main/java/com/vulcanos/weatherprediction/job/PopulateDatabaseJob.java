package com.vulcanos.weatherprediction.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class PopulateDatabaseJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final PopulateDatabaseTask populateDatabaseTask;

    public PopulateDatabaseJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, PopulateDatabaseTask populateDatabaseTask) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.populateDatabaseTask = populateDatabaseTask;
    }

    /**
     * Returns the step to populate the database.
     *
     * @return the step to populate the database.
     * @see PopulateDatabaseTask
     */
    public Step populateDatabaseStep() {
        return stepBuilderFactory.get("populateDatabaseStep")
                .tasklet(populateDatabaseTask)
                .build();
    }

    /**
     * Returns the job to populate the database.
     *
     * @return the job to populate the database.
     * @see PopulateDatabaseTask
     */
    @Bean
    public Job populateDatabase() {
        return jobBuilderFactory.get("populateDatabaseJob")
                .incrementer(new RunIdIncrementer())
                .start(populateDatabaseStep())
                .build();
    }
}
