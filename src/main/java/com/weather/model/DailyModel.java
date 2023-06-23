package com.weather.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyModel {
	
	public DailyModel(String time, Double rain_sum) {
		this.time = time;
		this.rain_sum = rain_sum;
	}
	@Id
	public String time;
	public Double rain_sum;

}
