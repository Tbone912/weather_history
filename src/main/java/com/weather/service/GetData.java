//This will get send a get Request for historical weather data
//https://open-meteo.com/en/docs/historical-weather-api
package com.weather.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetData {

	public static void getData() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String oikolab = "https://archive-api.open-meteo.com/v1/archive?latitude=33.75&longitude=-84.39&start_date=2000-05-18&end_date=2023-06-01&daily=rain_sum&timezone=auto&precipitation_unit=inch";

		ResponseEntity<String> response = restTemplate.getForEntity(oikolab, String.class);

		System.err.println(response.toString());
		File myFile = new File("weatherData.txt");
		FileWriter txtFile = new FileWriter("weatherData.txt");
		txtFile.write(response.toString());
		txtFile.close();
	}
}
