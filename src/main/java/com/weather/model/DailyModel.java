package com.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyModel {
	
	public DailyModel(String time, Double rain_sum) {
		this.time = time;
		this.rain_sum = rain_sum;
	}
	public String time;
	public Double rain_sum;

}
