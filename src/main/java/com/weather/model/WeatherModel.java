package com.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherModel {

	@JsonProperty("time")
	private String day;

	@JsonProperty("rain_sum")
	private String rain;

	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("longitude")
	private double longitude;

	@JsonProperty("generationtime_ms")
	private double generationtime_ms;

	@JsonProperty("utc_offset_seconds")
	private int utc_offset_seconds;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("timezone_abbreviation")
	private String timezone_abbreviation;

	@JsonProperty("elevation")
	private double elevation;

	public static class DailyUnits {

		@JsonProperty("time")
		private String time;

		@JsonProperty("rain_sum")
		private String rain_sum;

	}

	public static class DailyData {
		
		@JsonProperty("time")
		private List<String> listTime;

		@JsonProperty("rain_sum")
		private List<Double> listRain_sum;

	}

}