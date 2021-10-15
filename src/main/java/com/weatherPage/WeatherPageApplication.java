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

		long sunrise = 1634303084;
		long sunset = 1634344458;
		System.out.println("sunrise: " + formatTime(new Date(sunrise)));
		System.out.println("sunset: " + formatTime(new Date(sunset)));
	}

	static final DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("h:mm a", Locale.ENGLISH)
			.withZone(ZoneId.of("Asia/Kathmandu"));

	static String formatTime2(Instant time) {
		return formatter.format(time);
	}

	public static String formatTime(Date dateObject) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		return timeFormat.format(dateObject);
	}

}
