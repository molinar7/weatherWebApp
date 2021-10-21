package com.weatherPage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherPage.dto.CityInformationResponse;
import com.weatherPage.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/weather")
public class WeatherRestController {

    @Autowired
    WeatherService weatherService;


    @GetMapping()
    public CityInformationResponse getCityInformation(@RequestParam("city") String city) throws JsonProcessingException {
        return weatherService.getCityInformation(city);
    }


}
