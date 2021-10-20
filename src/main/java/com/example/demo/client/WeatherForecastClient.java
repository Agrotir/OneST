package com.example.demo.client;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherForecastClient {

    private final String WEATHER_FORECAST_ENDPOINT = "https://api.data.gov.sg/v1/environment/2-hour-weather-forecast";

    public WeatherForecastClient() {
    }

    public Map<String, Object> getData() {
        HttpEntity requestEntity = new HttpEntity(new HttpHeaders());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(WEATHER_FORECAST_ENDPOINT, HttpMethod.GET, requestEntity,
                Map.class);
        return response.getBody();
    }
}
