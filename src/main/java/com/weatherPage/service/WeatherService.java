package com.weatherPage.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherPage.dto.CityInformationResponse;

public interface WeatherService {

     CityInformationResponse getCityInformation(final String city) throws JsonProcessingException;
}
