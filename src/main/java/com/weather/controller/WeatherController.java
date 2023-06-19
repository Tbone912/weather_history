package com.weather.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.model.DailyModel;
import com.weather.service.GetData;
 
@RestController
public class WeatherController {
	
	@Autowired
	GetData getdata;
 
 
    @GetMapping("/getAllData")
    private List<DailyModel> getAllData() throws IOException {
    	
    	return GetData.cacheListData(GetData.getData());
       // return GetData.getData();
    }
 
}