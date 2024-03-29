//http://localhost:8080/h2
//CREATE TABLE DAILY_ENTITY (time VARCHAR(10), rain_sum DOUBLE);

package com.weather;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeatherHistoryApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherHistoryApplication.class, args);

	}

}
