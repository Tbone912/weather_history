package com.weather;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weather.service.GetData;

@SpringBootApplication
public class WeatherHistoryApplication {
	
	@Autowired
	static
	GetData getData;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherHistoryApplication.class, args);
	
		getData.getData();
	}

}
