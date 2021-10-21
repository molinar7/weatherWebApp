package com.weatherPage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherPage.dto.CityInformationResponse;
import com.weatherPage.dto.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

@Service
@ConfigurationProperties(prefix = "api")
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private  RestTemplate restTemplate;
    private String weatherUrl;
    private String apiKey;
    private String celsius;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public CityInformationResponse getCityInformation(final String city) throws JsonProcessingException {

        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(weatherUrl);
        uri.queryParam("q", city.replaceAll("\\s+",""));
        uri.queryParam("appid", apiKey);
        uri.queryParam("units", celsius);

        try {

            String resultString = restTemplate.getForObject(uri.toUriString(), String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode resultJson = objectMapper.readTree(resultString);

            return new CityInformationResponse()
                    .setTodayDate(now())
                    .setCityName(resultJson.get("name").asText())
                    .setOverallDescription(resultJson.get("weather").get(0).get("description").asText())
                    .setTemperature(resultJson.get("main").get("temp").asText() + "c")
                    .setSunriseTime(timeFormatSecondsToHour(resultJson.get("sys").get("sunrise").asText()))
                    .setSunsetTime(timeFormatSecondsToHour(resultJson.get("sys").get("sunset").asText()))
                    .setError(null);

        } catch (HttpClientErrorException ex)   {
            return new CityInformationResponse().setError(new Error(ex.getMessage(), ex.getStatusCode().toString()));
        }catch (Exception ex){
            return new CityInformationResponse().setError(new Error(ex.getMessage(), "500"));
        }


    }

    private String timeFormatSecondsToHour(String time) {
        Instant instant = Instant.ofEpochSecond(Long.parseLong(time));
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(("h:mm a")));
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }
}
