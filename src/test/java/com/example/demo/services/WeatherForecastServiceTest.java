package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.client.WeatherForecastClient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherForecastServiceTest {

    static WeatherForecastClient mockWeatherForecastClient;
    static WeatherForecastService weatherForecastService;

    @BeforeAll
    static void init() {
        mockWeatherForecastClient = Mockito.mock(WeatherForecastClient.class);
        weatherForecastService = new WeatherForecastService(mockWeatherForecastClient);
    }

    @Test
    void testGetForecasts() {
        List<Map<String, String>> mockForecasts = new ArrayList<>();
        Map<String, String> mockMap = new HashMap<>();
        mockMap.put("Area", "Ang Mo Kio");
        mockMap.put("forecast", "Light Rain");
        mockForecasts.add(mockMap);
        mockMap = new HashMap<String, String>();
        mockMap.put("Area", "Bedok");
        mockMap.put("forecast", "Light Rain");
        mockForecasts.add(mockMap);
        mockMap = new HashMap<String, String>();
        mockMap.put("Area", "Bishan");
        mockMap.put("forecast", "Light Rain");
        mockForecasts.add(mockMap);

        Map<String, Object> forecastMap = new HashMap<>();
        forecastMap.put("forecasts", mockForecasts);

        List<Object> items = new ArrayList<Object>();
        items.add(forecastMap);

        Map<String, Object> mockData = new HashMap<>();
        mockData.put("items", items);

        when(mockWeatherForecastClient.getData()).thenReturn(mockData);

        assertEquals(mockForecasts, weatherForecastService.getForecasts());
    }
}
