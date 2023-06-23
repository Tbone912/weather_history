//This will get send a get Request for historical weather data
//https://open-meteo.com/en/docs/historical-weather-api
package com.weather.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.model.DailyModel;
import com.weather.model.WeatherModel;
import com.weather.repository.H2Repository;

@Service
public class GetData {
	
	@Autowired
	static
	H2Repository h2Repository;

	public static WeatherModel getData() throws IOException {
		
		

		RestTemplate restTemplate = new RestTemplate();

		String oikolab = "https://archive-api.open-meteo.com/v1/archive?latitude=33.75&longitude=-84.39&start_date=2023-05-18&end_date=2023-06-01&daily=rain_sum&timezone=auto&precipitation_unit=inch";

		WeatherModel response = restTemplate.getForObject(oikolab, WeatherModel.class);

		return response;
	}

	public static List<DailyModel> cacheListData(WeatherModel weatherModel) {

		List<DailyModel> dailys = new ArrayList<>();
		
		List<String> time = weatherModel.daily.time;
		List<Double> rain_sum = weatherModel.daily.rain_sum;

		
		for (int i = 0; i < time.size() && i < rain_sum.size(); i++) {
	        String dailyTime = time.get(i);
	        Double dailyRain_Sum = rain_sum.get(i);

	        DailyModel dailyObj = new DailyModel(dailyTime, dailyRain_Sum);

	        h2Repository.save(dailyObj);

	        dailys.add(dailyObj);
	    }
		

		return dailys;

	}

}
