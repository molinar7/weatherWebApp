package com.weatherPage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherPage.dto.CityInformationResponse;
import com.weatherPage.dto.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.weatherPage.util.Constants;

import static java.time.LocalDate.now;

@Service
public class WeatherService {

    @Autowired
    private  RestTemplate restTemplate;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public CityInformationResponse getCityInformation(final String city) throws JsonProcessingException {

        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather");
        uri.queryParam("q", city);
        uri.queryParam("appid", Constants.API_KEY);
        uri.queryParam("units", Constants.CELCIUS);

        try {

            String resultString = restTemplate.getForObject(uri.toUriString(), String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode resultJson = objectMapper.readTree(resultString);

            return new CityInformationResponse()
                    .setTodayDate(now())
                    .setCityName(resultJson.get("name").asText())
                    .setOverallDescription(resultJson.get("weather").get(0).get("description").asText())
                    .setTemperature(resultJson.get("main").get("temp").asText() + "c")
                    .setSunriseTime(resultJson.get("sys").get("sunrise").asText())
                    .setSunsetTime(resultJson.get("sys").get("sunset").asText())
                    .setError(null);

        } catch (HttpClientErrorException ex)   {
            return new CityInformationResponse().setError(new Error(ex.getMessage(), ex.getStatusCode().toString()));
        }catch (Exception ex){
            return new CityInformationResponse().setError(new Error(ex.getMessage(), "500"));
        }


    }


}
