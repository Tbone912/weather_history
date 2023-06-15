//This will get send a get Request for historical weather data
//https://open-meteo.com/en/docs/historical-weather-api
package com.weather.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.weather.model.WeatherModel;

@Service
public class GetData {

	public static WeatherModel getData() throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setVisibility(
				VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

		WeatherModel weatherModel = new WeatherModel();
		RestTemplate restTemplate = new RestTemplate();

		String oikolab = "https://archive-api.open-meteo.com/v1/archive?latitude=33.75&longitude=-84.39&start_date=2023-05-18&end_date=2023-06-01&daily=rain_sum&timezone=auto&precipitation_unit=inch";

		WeatherModel response = restTemplate.getForObject(oikolab, WeatherModel.class);

		return response;
	}

}
