package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import com.example.demo.services.WeatherForecastService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherForecastController {

    WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/weather-forecast")
    public String getWeatherForecast(Model model) {
        List<Map<String, String>> listOfForecasts = weatherForecastService.getForecasts();
        model.addAttribute("listOfForecasts", listOfForecasts);
        return "weather-forecast";
    }
}
