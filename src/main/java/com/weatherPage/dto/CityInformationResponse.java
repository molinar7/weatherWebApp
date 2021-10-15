package com.weatherPage.dto;

import java.time.LocalDate;

public class CityInformationResponse {

    private LocalDate todayDate;
    private String cityName;
    private String overallDescription;
    private String temperature;
    private String sunriseTime;
    private String sunsetTime;
    private Error error;

    public LocalDate getTodayDate() {
        return todayDate;
    }

    public CityInformationResponse setTodayDate(LocalDate todayDate) {
        this.todayDate = todayDate;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public CityInformationResponse setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getOverallDescription() {
        return overallDescription;
    }

    public CityInformationResponse setOverallDescription(String overallDescription) {
        this.overallDescription = overallDescription;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public CityInformationResponse setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public CityInformationResponse setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
        return this;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }

    public CityInformationResponse setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
        return this;
    }

    public Error getError() {
        return error;
    }

    public CityInformationResponse setError(Error error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return "CityInformationResponse{" +
                "todayDate=" + todayDate +
                ", cityName='" + cityName + '\'' +
                ", overallDescription='" + overallDescription + '\'' +
                ", temperature='" + temperature + '\'' +
                ", sunriseTime='" + sunriseTime + '\'' +
                ", sunsetTime='" + sunsetTime + '\'' +
                ", error=" + error +
                '}';
    }
}
