package com.weatherPage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weatherPage.dto.CityInformationRequest;
import com.weatherPage.dto.CityInformationResponse;
import com.weatherPage.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;


    @GetMapping("/weather")
    public String greetingForm(Model model) {
        model.addAttribute("city", new CityInformationRequest());
        return "weatherForm";
    }

    @PostMapping("/weather")
    public String greetingSubmit(@ModelAttribute CityInformationRequest cityInformationRequest, Model model) throws JsonProcessingException {

        CityInformationResponse cityInformationResponse = new CityInformationResponse();

        if(!StringUtils.isEmpty(cityInformationRequest.getCityName())){
            cityInformationResponse = weatherService.getCityInformation(cityInformationRequest.getCityName());
        }

        model.addAttribute("cityInformationResponse", cityInformationResponse);

        return "weatherInformation";
    }
}
