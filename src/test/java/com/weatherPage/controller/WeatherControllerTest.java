package com.weatherPage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherPage.dto.CityInformationResponse;
import com.weatherPage.service.WeatherService;
import com.weatherPage.util.Constants;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class WeatherControllerTest {


    @MockBean
    private WeatherService weatherService;

    @Test
    public void getCityInformationWithRestTemplateTest() throws JsonProcessingException {
        CityInformationResponse chihuahuaResponse = new CityInformationResponse()
                .setError(null)
                .setCityName("Chihuahua")
                .setOverallDescription("broken clouds")
                .setTemperature("27.09c")
                .setSunriseTime("1634648832")
                .setSunsetTime("1634689816")
                .setTodayDate(LocalDate.now());


        Mockito.when(this.weatherService.getCityInformation("Chihuahua")).thenReturn(chihuahuaResponse);
        CityInformationResponse result = this.weatherService.getCityInformation("Chihuahua");
        Assert.assertEquals(result, chihuahuaResponse);
    }



}