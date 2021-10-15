package com.weatherPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class WeatherPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherPageApplication.class, args);
	}



}
