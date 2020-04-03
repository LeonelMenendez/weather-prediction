package com.vulcanos.weatherprediction.controller;

import com.vulcanos.weatherprediction.exception.ResourceNotFoundException;
import com.vulcanos.weatherprediction.model.DayWeatherConditionsModel;
import com.vulcanos.weatherprediction.model.SolarSystemWeatherConditionsModel;
import com.vulcanos.weatherprediction.service.DayWeatherConditionsService;
import com.vulcanos.weatherprediction.service.SolarSystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clima")
public class DayWeatherConditionsController {

    private final DayWeatherConditionsService dayWeatherConditionsService;
    private final SolarSystemService solarSystemService;

    public DayWeatherConditionsController(DayWeatherConditionsService dayWeatherConditionsService, SolarSystemService solarSystemService) {
        this.dayWeatherConditionsService = dayWeatherConditionsService;
        this.solarSystemService = solarSystemService;
    }

    /**
     * Returns the weather conditions of the specified day.
     *
     * @param day the day from which the weather conditions will be obtained.
     * @return the weather conditions of the solar system on the specified day.
     * @throws ResourceNotFoundException if there is no weather information for the specified day.
     * @see SolarSystemService#getWeatherConditions(int)
     */
    @GetMapping()
    public DayWeatherConditionsModel findWeatherConditionsByDay(@RequestParam(value = "dia") int day) throws ResourceNotFoundException {
        final DayWeatherConditionsModel dayWeatherConditionsModel = dayWeatherConditionsService.findWeatherConditionsByDay(day);

        if (dayWeatherConditionsModel == null) {
            throw new ResourceNotFoundException("No se tiene información del clima para el día " + day);
        }

        return dayWeatherConditionsModel;
    }

    /**
     * Returns information about the weather conditions of the period formed by
     * the specified <code>startDay</code> and <code>finalDay</code>.
     *
     * @param startDay the day the period begins.
     * @param finalDay the day the period ends.
     * @return information about the weather conditions of the specified period.
     * @see SolarSystemService#getSolarSystemWeatherConditionsInformation(int, int)
     */
    @GetMapping("/periodo")
    public SolarSystemWeatherConditionsModel getSolarSystemWeatherConditionsInformation(@RequestParam(value = "diaInicio") int startDay, @RequestParam(value = "diaFin") int finalDay) {
        return solarSystemService.getSolarSystemWeatherConditionsInformation(startDay, finalDay);
    }
}
