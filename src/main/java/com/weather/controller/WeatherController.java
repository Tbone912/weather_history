package com.weather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/insertData")
	private void insertData() throws IOException {

		getdata.singleData(getdata.cacheListData(getdata.getData()));

	}

}