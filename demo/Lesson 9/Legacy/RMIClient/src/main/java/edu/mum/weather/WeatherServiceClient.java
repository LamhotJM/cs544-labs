package edu.mum.weather;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.TemperatureInfo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class WeatherServiceClient {

	// Described in config
    @Autowired
    private WeatherService weatherService;

    public TemperatureInfo getTodayTemperature(String city) {
        List<Date> dates = Arrays.asList(new Date[]{new Date()});
        List<TemperatureInfo> temperatures =
                weatherService.getTemperatures(city, dates);
        return temperatures.get(0);
    }
}
