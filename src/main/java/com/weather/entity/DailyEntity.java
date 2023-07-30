package com.weather.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DailyEntity implements Serializable {

	public String toString() {
		return "Daily Data{" + "time=" + time + ", rain_sum=" + rain_sum + '}';
	}
	
	public DailyEntity(String time, Double rain_sum) {
		this.time = time;
		this.rain_sum = rain_sum;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String time;
	
	private Double rain_sum;
}
