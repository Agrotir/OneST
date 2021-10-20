package com.example.demo.services;

import java.util.List;
import java.util.Map;

import com.example.demo.client.WeatherForecastClient;

import org.springframework.stereotype.Service;

@Service
public class WeatherForecastService {

    WeatherForecastClient weatherForecastClient;

    public WeatherForecastService(WeatherForecastClient weatherForecastClient) {
        this.weatherForecastClient = weatherForecastClient;
    }

    public List<Map<String, String>> getForecasts() {
        Map<String, Object> data = weatherForecastClient.getData();
        // Map<String, List<Map<String, String>>>
        List<Object> itemData = (List<Object>) data.get("items");
        Map<String, Object> itemDataFirstElement = (Map<String, Object>) itemData.get(0);
        List<Map<String, String>> listOfForecastData = (List<Map<String, String>>) itemDataFirstElement
                .get("forecasts");
        return listOfForecastData;
    }
}
