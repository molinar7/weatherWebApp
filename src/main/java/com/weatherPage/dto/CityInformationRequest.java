package com.weatherPage.dto;

public class CityInformationRequest {

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityInformationRequest{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
