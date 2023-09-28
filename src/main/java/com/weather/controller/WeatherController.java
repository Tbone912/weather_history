package com.weather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.DailyEntity;
import com.weather.model.WeatherModel;
import com.weather.service.GetData;

@RestController
public class WeatherController {

	@Autowired
	GetData getdata;

	@GetMapping("/showData")
	private WeatherModel getAllData() throws IOException {

		return getdata.getData();
	}
	
	@GetMapping("/getData/{id}")
	private String getDaily(@PathVariable int id) throws IOException {

		return getdata.getDailyData(id).toString();
	}

	@PostMapping("/insertData")
	private void insertData() throws IOException {

		getdata.loopData(getdata.getListData(getdata.getData()));
		
	}
	
	@PostMapping("/insertOneData")
	private void insertOneData(DailyEntity data) throws IOException {

		
	}


}