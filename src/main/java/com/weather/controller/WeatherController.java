package com.weather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.model.WeatherModel;
import com.weather.service.GetData;
 
@RestController
public class WeatherController {
	
	@Autowired
	GetData getdata;
 
 
    @GetMapping("/getAllData")
    private WeatherModel getAllData() throws IOException {
        return GetData.getData();
    }
 
}