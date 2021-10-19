package com.weatherPage.service;

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


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class WeatherServiceTest {


    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void getCityInformationWithRestTemplateTest() {

        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(Constants.API_URL);
        uri.queryParam("q", "Chihuahua");
        uri.queryParam("appid", Constants.API_KEY);
        uri.queryParam("units", Constants.CELCIUS);

        Mockito.when(this.restTemplate.getForObject(uri.toUriString(), String.class)).thenReturn("{\"todayDate\":\"2021-10-19\",\"cityName\":\"Chihuahua\",\"overallDescription\":\"broken clouds\",\"temperature\":\"27.09c\",\"sunriseTime\":\"1634648832\",\"sunsetTime\":\"1634689816\",\"error\":null}");
        String resultJson =  this.restTemplate.getForObject(uri.toUriString(), String.class);
        Assert.assertEquals(resultJson,"{\"todayDate\":\"2021-10-19\",\"cityName\":\"Chihuahua\",\"overallDescription\":\"broken clouds\",\"temperature\":\"27.09c\",\"sunriseTime\":\"1634648832\",\"sunsetTime\":\"1634689816\",\"error\":null}");
    }

}