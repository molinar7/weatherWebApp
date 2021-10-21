package com.weatherPage.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class WeatherServiceImplTest {


    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void getCityInformationWithRestTemplateTest() {

        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather");
        uri.queryParam("q", "Chihuahua");
        uri.queryParam("appid", "0972a546221a36585c5e3de778b00ebc");
        uri.queryParam("units", "METRIC");

        Mockito.when(this.restTemplate.getForObject(uri.toUriString(), String.class)).thenReturn("{\"todayDate\":\"2021-10-19\",\"cityName\":\"Chihuahua\",\"overallDescription\":\"broken clouds\",\"temperature\":\"27.09c\",\"sunriseTime\":\"1634648832\",\"sunsetTime\":\"1634689816\",\"error\":null}");
        String resultJson =  this.restTemplate.getForObject(uri.toUriString(), String.class);
        Assert.assertEquals(resultJson,"{\"todayDate\":\"2021-10-19\",\"cityName\":\"Chihuahua\",\"overallDescription\":\"broken clouds\",\"temperature\":\"27.09c\",\"sunriseTime\":\"1634648832\",\"sunsetTime\":\"1634689816\",\"error\":null}");
    }

}