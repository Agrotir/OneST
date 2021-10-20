package com.example.demo.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastResponse {
    Map<String, String> forecasts;

    public WeatherForecastResponse() {
    }

    public Map<String, String> getForecasts() {
        return forecasts;
    }

    public void setForecasts(Map<String, String> forecasts) {
        this.forecasts = forecasts;
    }
}
