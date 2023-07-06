package com.weather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.DailyEntity;
import com.weather.model.WeatherModel;
import com.weather.repository.H2Repository;
import com.weather.service.GetData;
 
@RestController
public class WeatherController {
	
	@Autowired
	GetData getdata;
	
	 @Autowired
	 private H2Repository h2Repository;
 
 
    @GetMapping("/showData")
    private WeatherModel getAllData() throws IOException {
    	
       return GetData.getData();
    }
 

    @PostMapping("/insertData")
    private void insertData() throws IOException {
    	
       DailyEntity firstTry = new DailyEntity("2023-05-22", 0.0);
       h2Repository.save(firstTry);
    }
    
}